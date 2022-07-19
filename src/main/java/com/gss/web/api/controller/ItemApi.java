package com.gss.web.api.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gss.web.api.dto.ItemDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main/nav")
public class ItemApi {
	@GetMapping("/item")
	public String GetNavPage(Model model) {
		return "main/mainItem/gssItem";
	}
	
	@GetMapping("/getsearchList")
	@ResponseBody
	private List<ItemDto> getSearchList(@RequestParam("type") String type,
			@RequestParam("ketword") String keyword, Model model) throws Exception{
		ItemDto itemDto = new ItemDto();
		itemDto.setClassificationType(type);
		itemDto.setKeyword(keyword);
		return null;
	}
}
