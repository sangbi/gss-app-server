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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String itemPage(Model model, @RequestParam(defaultValue="1",required =false)Integer page) {
		List<Item> itemList = new ArrayList<>();
		itemList = itemService.selectAllItemPaging(page);
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("itemList", itemList);
		model.addAttribute("start",1);
		model.addAttribute("end",itemService.selectItemCount());
		model.addAttribute("page",page);
		
		return "item/gssItem";
	}

	@GetMapping("/itemSearch")
	public String postSearchList(@RequestParam(value="type") String type,
			 @RequestParam(value="keyword") String keyword,
								 @RequestParam(defaultValue="1",required =false)Integer page ,Model model, RedirectAttributes redirect) throws Exception{
		List<Item> itemList = new ArrayList<>();
		Item item = new Item(keyword, page);

		if (type.equals("itemname")) {
			itemList = itemService.selectSearchItemNamePaging(item);
		}
		else {
			itemList = itemService.selectSearchClassificationPaging(item);
		}
		
		model.addAttribute("type", keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("itemList", itemList);
		model.addAttribute("start",1);
		model.addAttribute("end",itemService.selectItemCount());
		model.addAttribute("page",page);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		
		return "item/gssItemSearch";
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
