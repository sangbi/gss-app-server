package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.common.domain.Boss;
import com.gss.web.common.domain.Item;
import com.gss.web.common.service.BossService;
import com.gss.web.common.service.ItemOfBossService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boss")
public class BossApi {
	@Autowired
	private BossService bossService;
	
	@Autowired
	private ItemOfBossService itemOfBossService;

	@GetMapping("/bossList")
	public String GetNavPage(Model model) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBoss();
		model.addAttribute("bossList", bossList);
		
		return "boss/gssBoss";
	}	
	
	@GetMapping("/selectBoss")
	public String bossDropItem(Model model,@RequestParam("bossName") String bossName, 
							@RequestParam("bossGrade") String bossGrade) {
		Map<String, String> map= new HashMap<String, String>();
		map.put("bossName", bossName);
		map.put("bossGrade", bossGrade);
		List<Integer> result= itemOfBossService.selectAllItemOfBoss(map);
		Item[] itemList = new Item[result.size()];
		
		
		for (int i = 0; i < result.size(); i++) {
			itemList[i] =  itemOfBossService.selectByBossItem(result.get(i));
			System.out.println(itemList[i].getItemName() + " : " + itemList[i].getClassification() + " : " + itemList[i].getItemImagepath() );
		}
		
		model.addAttribute("itemList", itemList);
		
		return "/boss/bossDropItem";
	}
}
