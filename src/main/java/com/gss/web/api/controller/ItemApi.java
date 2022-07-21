package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.api.dto.ItemDto;
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
	public String GetNavPage(Model model) {
		List<Item> itemList = new ArrayList<>();
		
		itemList = itemService.selectAllItem();
		model.addAttribute("itemList", itemList);
		
		return "item/gssItem";
	}

	@PostMapping("/itemList")
	private String getSearchList(@RequestParam("type") String type,
								 @RequestParam("keyword") String keyword, Model model) throws Exception{
		List<ItemDto> itemList = new ArrayList<>();
		
		if (type.equals("itemname")) {
			itemList = itemService.selectSearchItemName(keyword);
			model.addAttribute("itemList", itemList);
		} else {
			itemList = itemService.selectSearchClassification(keyword);
			model.addAttribute("itemList", itemList);
		}
		
		return "item/gssItem";
	}	

}
