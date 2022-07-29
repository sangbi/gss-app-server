package com.gss.web.api.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.api.dto.PriceRatioDto;
import com.gss.web.api.dto.ResultTabDto;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateComplete;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemInfo;
import com.gss.web.common.domain.PartyGetItem;
import com.gss.web.common.domain.UserRatioInfo;
import com.gss.web.common.service.CalculateService;
import com.gss.web.common.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/calculate")
public class CalculateApi {
	@Autowired
	private CalculateService calculateService;
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/partyList")
	public String showMyPartyList() {
		return "calculate/calculateMain";
	}
	
	@PostMapping("/getPartyList")
	@ResponseBody
	public List<CalculateMain> getPartyList(HttpServletRequest req){
		AuthInfo loginUser =  (AuthInfo) req.getSession().getAttribute("authInfo");
		int userNum = calculateService.selectByUserId(loginUser.getId());
		return calculateService.selectByUserNumber(userNum);
	}
	
	@GetMapping("/calculateList")
	public String showCalculateList(@RequestParam("partyName") String partyName, Model model) {
		List<Calculate> calcMember = new ArrayList<Calculate>();
		List<Calculate> calcBoss = new ArrayList<Calculate>();
		List<Calculate> calcAllMember = new ArrayList<Calculate>();
		List<Item> itemList = new ArrayList<Item>(); 
		List<PartyGetItem> pgiList = new ArrayList<PartyGetItem>();
		long price = 0;	
		List<Integer> bossNum = calculateService.selectBossNumByPartyName(partyName);
		List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
		for(int boss : bossNum) {
			for(ItemInfo item : calculateService.selectItemByItemNumber(boss)) {
				itemInfo.add(item);
			}
		}
		
		int count = calculateService.selectCountMember(partyName);
		Calculate partyLeader = calculateService.selectPartyLeader(partyName);
		calcMember = calculateService.selectPartyMember(partyName);
		calcBoss = calculateService.selectBossNameAndGrade(partyName);
		calcAllMember = calculateService.selectMemberAll(partyName);
		itemList = itemService.selectAllItem();
		pgiList = calculateService.selectItemNameAndPrice(partyName);
		
		for (int i = 0; i < pgiList.size(); i++) {
			price += pgiList.get(i).getItemSalePrice()  ;
		}
		
		price = price - (price * 5) / 100 ;
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		String money = df.format(price);
		
		model.addAttribute("partyName", partyName);
		model.addAttribute("count", count);
		model.addAttribute("partyLeader", partyLeader);
		model.addAttribute("calcMember", calcMember);
		model.addAttribute("allMember", calcAllMember);
		model.addAttribute("calcBoss", calcBoss);
		model.addAttribute("itemList", itemList);
		model.addAttribute("pgiList", pgiList);
		model.addAttribute("price", price);
		model.addAttribute("money", money);
		model.addAttribute("bossItemList", itemInfo);
		
		return "calculate/calculate";
	}
	
	@PostMapping("/calcInsert")
	@ResponseBody
	public int calcList(@RequestParam("itemName") List<String> itemName, 
									@RequestParam("itemPrice") List<Integer> itemPrice, 
									@RequestParam("partyName") String partyName) {
		int partyGetItem = 0;
		for(int i=0;i<itemName.size();i++) {
			PartyGetItemDto pgiDto = new PartyGetItemDto(itemName.get(i), itemPrice.get(i), partyName);
			partyGetItem += calculateService.insertItemNameAndPrice(pgiDto);
		}
		return partyGetItem;
	}
	
	@PostMapping("/itemSearch")
	@ResponseBody
	public List<Item> itemSearch(@RequestParam("itemName") String itemName) {
		List<Item> itemList = itemService.selectSearchItemName(itemName);
		return itemList;
	}
	
	@PostMapping("/calculateList")
	public String calcInsert(@RequestParam("partyName") String partyName, Model model) {
		showCalculateList(partyName, model);	
		return "calculate/calculate";
	}
	
	@PostMapping("/ratioSetting")
	public String ratioSetting(@RequestParam("ratio") List<Integer> ratio,
								@RequestParam("memberList") List<String> memberList,
								@RequestParam("partyName") String partyName,
								RedirectAttributes redirectAttributes) {
		int priceRatio = 0;
		int sum = 0;
		PriceRatioDto priceRatioDto = new PriceRatioDto();
		
		for(Integer str : ratio) {
			sum += str;
		}
		
		for(int i=0;i<ratio.size();i++) {
			priceRatioDto = new PriceRatioDto(ratio.get(i), memberList.get(i), partyName);
			priceRatio += calculateService.updateMemberOfPricePercent(priceRatioDto);
		}
		redirectAttributes.addAttribute("partyName", partyName);
		
		return "redirect:/calculate/calculateList";
	}
	
	@PostMapping("/ratioComplete")
	public String calculateComplete(@RequestParam("partyName") String partyName, @RequestParam("price") long price) {
		int resultState = calculateService.updateResultState(partyName);
		List<Integer> pgiKey = calculateService.selectPartyGetItemNumber(partyName);
		int memberCount = calculateService.selectCountMember(partyName);
		int partyNum = calculateService.selectPartyNum(partyName);
		List<UserRatioInfo> userNum = calculateService.selectUserRatioInfo(partyName);
		int[] memberOfPartyNum = new int [userNum.size()];
		
		long[] divPrice = new long [userNum.size()];
		int resultTab = 0;
		
		for (int i = 0; i < userNum.size(); i++) {
			memberOfPartyNum[i] = calculateService.selectMemberOfPartyNum(userNum.get(i));
		}
		
		for (int i = 0; i < userNum.size(); i++) {
			divPrice[i] = (price * userNum.get(i).getDivisionPercent()) / 100;
		}

		for(int i = 0; i < userNum.size(); i++) {
			for (int j = 0; j < pgiKey.size(); j++) {
				ResultTabDto resultTabDto = new ResultTabDto(userNum.get(i).getGssUserNum(), memberOfPartyNum[i], pgiKey.get(j), memberCount, divPrice[i]);
				resultTab = calculateService.insertResultTab(resultTabDto);
			}
		}
		
		return "redirect:/main/home";
	}
	
	@PostMapping("/calculateComplete")
	public String calculateComplete(@RequestParam("userId") String userId, Model model) {
		List<CalculateComplete> calculateComplet = calculateService.selectCalculateCompletList(userId);
		model.addAttribute("calculateComplete", calculateComplet);
		
		return "calculate/calculateComplete";
	}
	
	@GetMapping("/calculateCompleteList")
	public String calculateCompleteList(@RequestParam("partyName") String partyName, Model model) {
		List<Calculate> calcMember = new ArrayList<Calculate>();
		List<Calculate> calcBoss = new ArrayList<Calculate>();
		List<Calculate> calcAllMember = new ArrayList<Calculate>();
		List<PartyGetItem> pgiList = new ArrayList<PartyGetItem>();
		long price = 0;
		
		int count = calculateService.selectCountMember(partyName);
		Calculate partyLeader = calculateService.selectPartyLeader(partyName);
		calcMember = calculateService.selectPartyMember(partyName);
		calcBoss = calculateService.selectBossNameAndGrade(partyName);
		calcAllMember = calculateService.selectMemberAll(partyName);
		pgiList = calculateService.selectCalculateCompleteItemList(partyName);
		
		for (int i = 0; i < pgiList.size(); i++) {
			price += pgiList.get(i).getItemSalePrice()  ;
		}
		
		price = price - (price * 5) / 100 ;		
		
		model.addAttribute("partyName", partyName);
		model.addAttribute("count", count);
		model.addAttribute("partyLeader", partyLeader);
		model.addAttribute("calcMember", calcMember);
		model.addAttribute("allMember", calcAllMember);
		model.addAttribute("calcBoss", calcBoss);
		model.addAttribute("pgiList", pgiList);
		model.addAttribute("price", price);
		
		return "calculate/calculateCompleteList";
	}
	
	@PostMapping("/deleteItem")
	public String deletePartyGetItem (@RequestParam("pgiKey") int pgiKey,
										@RequestParam("partyName") String partyName,
										RedirectAttributes redirectAttributes ) {
		int delete = calculateService.deletePartyGetItem(pgiKey);
		redirectAttributes.addAttribute("partyName", partyName);
		
		return"redirect:/calculate/calculateList";
	}
}
