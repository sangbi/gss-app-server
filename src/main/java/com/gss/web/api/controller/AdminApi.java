package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.BossDto;
import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.domain.Boss;
import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemOfBoss;
import com.gss.web.common.domain.Member;
import com.gss.web.common.service.BossService;
import com.gss.web.common.service.FileService;
import com.gss.web.common.service.ItemOfBossService;
import com.gss.web.common.service.ItemService;
import com.gss.web.common.service.MemberServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminApi {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private BossService bossService;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemOfBossService itemOfBossService;

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@GetMapping("/main")
	public String adminMain(HttpSession session) {	
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}else {
			AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
			Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
			if(member.getPrivilge().equals("ADMIN")) {
				return "admin/adminMain";
			}
			else {
				return "redirect:/main/home";
			}
		}
	}

	@GetMapping("/boss")
	public String adminBoss(Model model,@RequestParam(defaultValue="1",required =false)Integer page,HttpSession session) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBossPaging(page);
		model.addAttribute("bossList", bossList);
		model.addAttribute("start",1);
		model.addAttribute("end",bossService.selectBossCount());
		model.addAttribute("page",page);
		model.addAttribute("bossList", bossList);
		
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}else {
			AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
			Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
			if(member.getPrivilge().equals("ADMIN")) {
				return "admin/boss";
			}
			else {
				return "redirect:/main/home";
			}
		}
	}
	
	@GetMapping("/addBoss")
	public String insertBoss(@ModelAttribute("BossDto") BossDto bossDto,HttpSession session) {
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}else {
			AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
			Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
			if(member.getPrivilge().equals("ADMIN")) {
				return "/admin/boss/insertBoss";
			}
			else {
				return "redirect:/main/home";
			}
		}
	}
	
	@PostMapping("/addBoss")
	public String insertBossReq(@ModelAttribute("BossDto") BossDto bossDto, HttpServletRequest req,Model model) {		
		String uploadPath = req.getSession().getServletContext().getRealPath("/").concat("resources"+"/"+"bossImage");
		String urlPath="";
		MultipartFile file = bossDto.getBossImagepath();
		String fileName=file.getOriginalFilename();
		String path = fileService.fileUpload(file, fileName,uploadPath);
		Boss boss;
		
		if (!path.equals("")) {
			path="resources/bossImage/"+fileName;
				boss=new Boss(bossDto.getBossName(),path,bossDto.getBossGrade());
				urlPath=bossService.bossExistence(boss);
				bossService.bossExistence(boss);
			   } else {
				 urlPath = "/admin/boss/bossList";
			   }		
		
		return urlPath;
	}

	@GetMapping("/selectBoss")
	public String readBoss( Model model, @RequestParam("bossName") String bossName, 
							@RequestParam("bossGrade") String bossGrade) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("bossName", bossName);
		map.put("bossGrade", bossGrade);
		
		Boss boss = bossService.selectByBossNameAndGrade(map);
		model.addAttribute("bossName", bossName);
		model.addAttribute("bossGrade", bossGrade);
		model.addAttribute("bossList",boss);
		
		return "/admin/boss/selectByBoss";
	}

	@GetMapping("/deleteBoss")
	public String deleteByBoss(Model model,@RequestParam("bossName") String bossName,
							@RequestParam("bossGrade") String bossGrade) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("bossName", bossName);
		map.put("bossGrade", bossGrade);
		int result = bossService.deleteByBossName(map);
		
		return "redirect:/admin/boss";
	}
	
	@GetMapping("/item")
	public String adminItem(Model model, @RequestParam(defaultValue="1",required =false)Integer page,HttpSession session) {
		List<Item> itemList = new ArrayList<>();
		itemList = itemService.selectAllItemPaging(page);

		model.addAttribute("itemList", itemList);
		model.addAttribute("itemList", itemList);
		model.addAttribute("start",1);
		model.addAttribute("end",itemService.selectItemCount());
		model.addAttribute("page",page);
		
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}else {
			AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
			Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
			if(member.getPrivilge().equals("ADMIN")) {
				return "/admin/item/itemList";
			}
			else {
				return "redirect:/main/home";
			}
		}
	}

	@GetMapping("/addItem")
	public String insertItem(@ModelAttribute("ItemDto") ItemDto itemDto,HttpSession session) {
		
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}else {
			AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
			Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
			if(member.getPrivilge().equals("ADMIN")) {
				return "/admin/item/insertItem";
			}
			else {
				return "redirect:/main/home";
			}
		}	
	}
	
	@PostMapping("/addItem")
	public String insertItemReq(@ModelAttribute("ItemDto") ItemDto itemDto, HttpServletRequest req,Model model) {	
		String uploadPath = req.getSession().getServletContext().getRealPath("/").concat("resources"+"/"+"itemImage");
		String urlPath="";
		MultipartFile file = itemDto.getItemImagepath();
		String fileName=file.getOriginalFilename();
		String path = fileService.fileUpload(file, fileName,uploadPath);
		Item item;
		
		if (!path.equals("")) {
			path="resources/itemImage/"+fileName;
				item=new Item(itemDto.getItemName(),path,itemDto.getClassification());
				urlPath=itemService.itemExistence(item);
				itemService.itemExistence(item);
			   } else {
				 urlPath = "/admin/item/itemList";
			   }		
		
		return urlPath;
	}
	
	@GetMapping("/selectItem")
	public String readItem(Model model,HttpServletRequest req, @RequestParam("itemName") String itemName,
							@RequestParam("classification") String classification) {
		Map<String, String> map= new HashMap<String, String>();
		
		map.put("classification", classification);
		map.put("itemName", itemName);
		Item item= itemService.selectByItemNameAndClassification(map);
		model.addAttribute("itemList",item);
		
		return "/admin/item/selectByItem";
	}

	@GetMapping("/deleteItem")
	public String deleteByItem(Model model,@RequestParam("itemName") String itemName,
							@RequestParam("classification") String classification) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("itemName", itemName);
		map.put("classification", classification);
		
		int result = itemService.deleteByItemName(map);
		
		return "redirect:/admin/item";
	}
	
	@GetMapping("/bossAndDrop")
	public String adminDrop(Model model,HttpServletRequest req,@RequestParam(defaultValue="1",required =false)Integer page,HttpSession session) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBossPaging(page);		
		model.addAttribute("bossList", bossList);
		model.addAttribute("start",1);
		model.addAttribute("end",bossService.selectBossCount());
		model.addAttribute("page",page);
		
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}else {
			AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
			Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
			if(member.getPrivilge().equals("ADMIN")) {
				return "/admin/bossForDrop/dropBossList";
			}
			else {
				return "redirect:/main/home";
			}
		}
	}
	
	@GetMapping("/bossDropItem")
	public String bossDropItem(Model model,@RequestParam("bossName") String bossName, 
							@RequestParam("bossGrade") String bossGrade) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("bossName", bossName);
		map.put("bossGrade", bossGrade);
		List<Integer> result= itemOfBossService.selectAllItemOfBoss(map);	
		Item[] itemList = new Item[result.size()];
		
		for (int i = 0; i < result.size(); i++) {
			itemList[i] =  itemOfBossService.selectByBossItem(result.get(i));
		}
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("bossName",bossName);
		model.addAttribute("bossGrade",bossGrade);
		
		return "/admin/bossForDrop/bossDropForItem";
	}
	
	@GetMapping("/addDropItem")
	public String showDropItem(Model model,@RequestParam("bossName") String bossName, 
							@RequestParam("bossGrade") String bossGrade,
							@RequestParam(defaultValue="1",required =false)Integer page,
							RedirectAttributes redirectAttribute) {
		
		Map<String, String> map= new HashMap<String, String>();
		map.put("bossName", bossName);
		map.put("bossGrade", bossGrade);
		
		List<Integer> result= itemOfBossService.selectInsertItemList(map);
		List<Item> allItemList=itemService.selectAllItemPaging(page);
		for(int i=0; i<allItemList.size(); i++) {
			for(int j=0; j<result.size(); j++) {
				if(allItemList.get(i).getItemNum() == result.get(j)) {
					allItemList.remove(i);
					i--;
				}
			}
		}
		
		model.addAttribute("item",allItemList);
		model.addAttribute("bossName", bossName);
		model.addAttribute("bossGrade", bossGrade);
		model.addAttribute("start",1);
		model.addAttribute("end",itemService.selectItemCount());
		model.addAttribute("page",page);
		
		redirectAttribute.addAttribute("bossName", bossName);
		redirectAttribute.addAttribute("bossGrade", bossGrade);
		
		return "/admin/bossForDrop/insertDropItem";
	}
	
	@GetMapping("/insertDropItem")
	public String insertDropItem(Model model,@RequestParam("itemNum") int itemNum, 
										@RequestParam("bossName") String bossName, 
										@RequestParam("bossGrade") String bossGrade,
										RedirectAttributes redirectAttribute) {
		ItemOfBoss itemOfBoss = new ItemOfBoss(itemNum,bossName,bossGrade);
		int result = itemOfBossService.insertItemOfBoss(itemOfBoss);
		
		model.addAttribute("itemList", result);
		redirectAttribute.addAttribute("bossName", bossName);
		redirectAttribute.addAttribute("bossGrade", bossGrade);
		
		return "redirect:/admin/bossDropItem";
	}
	
	@GetMapping("/deleteDropItem")
	public String deleteDropItem(@RequestParam("itemNum") int itemNum, 
									@RequestParam("bossName") String bossName,
									@RequestParam("bossGrade") String bossGrade,
									RedirectAttributes redirectAttribute) {
		ItemOfBoss itemOfBoss = new ItemOfBoss(itemNum, bossName, bossGrade);
		int del = itemOfBossService.deleteItemListByItemNum(itemOfBoss);
		
		redirectAttribute.addAttribute("bossName", bossName);
		redirectAttribute.addAttribute("bossGrade", bossGrade);
		
		return "redirect:/admin/bossDropItem";
	}
}
