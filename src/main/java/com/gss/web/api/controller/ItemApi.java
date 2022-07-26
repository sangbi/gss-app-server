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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.common.domain.Item;
import com.gss.web.common.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemApi {
	@Autowired
	private ItemService itemService;

	@GetMapping("/itemList")
	public String itemPage(Model model) {
		List<Item> itemList = new ArrayList<>();
		
		itemList = itemService.selectAllItem();
		model.addAttribute("itemList", itemList);
		
		return "item/gssItem";
	}

	@PostMapping("/itemList")
	private String getSearchList(@RequestParam("type") String type,
								 @RequestParam("keyword") String keyword, Model model) throws Exception{
		List<Item> itemList = new ArrayList<>();
		
		if (type.equals("itemname")) {
			itemList = itemService.selectSearchItemName(keyword);
			model.addAttribute("itemList", itemList);
		} else {
			itemList = itemService.selectSearchClassification(keyword);
			model.addAttribute("itemList", itemList);
		}
		
		return "item/gssItem";
	}	
	
	@GetMapping("/gssSelectItem")
	public String readItem(Model model,HttpServletRequest req, @RequestParam("itemName") String itemName,
							@RequestParam("classification") String classification) {
		Map<String, String> map= new HashMap<String, String>();
		
		map.put(""+"classification", classification);
		map.put(""+"itemName", itemName);
		Item item= itemService.selectByItemNameAndClassification(map);
		model.addAttribute("itemList"+"",item);
		
		return "/item/gssSelectByItem";
	}
}
