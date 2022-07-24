package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gss.web.api.dto.BossDto;
import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.domain.Boss;
import com.gss.web.common.domain.Item;
import com.gss.web.common.service.BossService;
import com.gss.web.common.service.FileService;
import com.gss.web.common.service.ItemService;

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

	@GetMapping("/main")
	public String adminMain() {		
		return "admin/adminMain";
	}

	@GetMapping("/boss")
	public String adminBoss(Model model) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBoss();
		model.addAttribute("bossList", bossList);
		
		return "/admin/boss/bossList";
	}
	
	@GetMapping("/addBoss")
	public String insertBoss(@ModelAttribute("BossDto") BossDto bossDto) {
		return "/admin/boss/insertBoss";
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
	public String readBoss( Model model, @RequestParam("bossName") String bossName, @RequestParam("bossGrade") String bossGrade) {
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
	public String adminItem(Model model) {
		List<Item> itemList = new ArrayList<>();
		
		itemList = itemService.selectAllItem();
		model.addAttribute("itemList", itemList);
		System.out.println("아이템 페이지");
		
		return "/admin/item/itemList";
	}

	@GetMapping("/addItem")
	public String insertItem(@ModelAttribute("ItemDto") ItemDto itemDto) {
		return "/admin/item/insertItem";
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
	
	@GetMapping("/bossAndDrop")
	public String adminDrop(Model model,HttpServletRequest req) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBoss();
		model.addAttribute("bossList", bossList);
		
		return "/admin/bossForDrop/dropBossList";
	}
	
	@GetMapping("/selectItem")
	public String readItem(Model model,HttpServletRequest req, @RequestParam("itemName") String itemName,
							@RequestParam("classification") String classification) {
		Map<String, String> map= new HashMap<String, String>();
		
		map.put(""+"classification", classification);
		map.put(""+"itemName", itemName);
		Item item= itemService.selectByItemNameAndClassification(map);
		model.addAttribute("itemList"+"",item);
		
		return "/admin/item/selectByItem";
	}
}
