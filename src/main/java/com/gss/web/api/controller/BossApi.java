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
	public String GetNavPage(Model model,@RequestParam(defaultValue="1",required =false)Integer page) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBossPaging(page);
		model.addAttribute("bossList", bossList);
		model.addAttribute("start",1);
		model.addAttribute("end",bossService.selectBossCount());
		model.addAttribute("page",page);
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
		Boss boss = bossService.selectByBossNameAndGrade(map);
		
		for (int i = 0; i < result.size(); i++) {
			itemList[i] =  itemOfBossService.selectByBossItem(result.get(i));
		}
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("bossList",boss);
		
		return "/boss/bossDropItem";
	}
}
