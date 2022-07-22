package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gss.web.common.domain.Boss;
import com.gss.web.common.service.BossService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boss")
public class BossApi {
	@Autowired
	private BossService bossService;

	@GetMapping("/bossList")
	public String GetNavPage(Model model) {
		List<Boss> bossList = new ArrayList<>();
		
		bossList = bossService.selectAllBoss();
		model.addAttribute("bossList", bossList);
		
		return "boss/gssBoss";
	}	
}
