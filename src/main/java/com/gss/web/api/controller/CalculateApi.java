package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.PartyGetItem;
import com.gss.web.common.service.CalculateService;
import com.gss.web.common.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class CalculateApi {
	@Autowired
	private CalculateService calculateService;
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/partyList")
	public String showMyPartyList(@RequestParam("userId") String userId, Model model) {
		int userNum = calculateService.selectByUserId(userId);

		List<CalculateMain> userList = new ArrayList<CalculateMain>();
		userList = calculateService.selectByUserNumber(userNum);
		model.addAttribute("userList", userList);

		return "calculate/calculateMain";
	}
	
	@GetMapping("/calculateList")
	public String showCalculateList(@RequestParam("partyName") String partyName, Model model) {
		List<Calculate> calcMember = new ArrayList<Calculate>();
		List<Calculate> calcBoss = new ArrayList<Calculate>();
		List<Item> itemList = new ArrayList<Item>(); 
		List<PartyGetItem> pgiList = new ArrayList<PartyGetItem>();
		
		int count = calculateService.selectCountMember(partyName);
		String partyLeader = calculateService.selectPartyLeader(partyName);
		calcMember = calculateService.selectPartyMember(partyName);
		calcBoss = calculateService.selectBossNameAndGrade(partyName);
		itemList = itemService.selectAllItem();
		pgiList = calculateService.selectItemNameAndPrice(partyName);
		
		model.addAttribute("partyName", partyName);
		model.addAttribute("count", count);
		model.addAttribute("partyLeader", partyLeader);
		model.addAttribute("calcMember", calcMember);
		model.addAttribute("calcBoss", calcBoss);
		model.addAttribute("itemList", itemList);
		model.addAttribute("pgiList", pgiList);
		
		return "calculate/calculate";
	}
	
	@PostMapping("/calcInsert")
	@ResponseBody
	public int calcList(@RequestParam("itemName") List<String> itemName, 
									@RequestParam("itemPrice") List<Integer> itemPrice, 
									@RequestParam("partyName") String partyName) {
		System.out.println(partyName);
		int partyGetItem = 0;
		for(int i=0;i<itemName.size();i++) {
			PartyGetItemDto pgiDto = new PartyGetItemDto(itemName.get(i), itemPrice.get(i), partyName);
			partyGetItem += calculateService.insertItemNameAndPrice(pgiDto);
		}
		System.out.println(partyGetItem);
		return partyGetItem;
	}
	
	@PostMapping("/calculateList")
	public String calcInsert(@RequestParam("partyName") String partyName, Model model) {
		showCalculateList(partyName, model);
			
		return "calculate/calculate";
	}
}
