package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.service.CalculateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class CalculateApi {
	@Autowired
	private CalculateService calculateService;

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
		
		int count = calculateService.selectCountMember(partyName);
		String partyLeader = calculateService.selectPartyLeader(partyName);
		calcMember = calculateService.selectPartyMember(partyName);
		calcBoss = calculateService.selectBossNameAndGrade(partyName);
		
		model.addAttribute("partyName", partyName);
		model.addAttribute("count", count);
		model.addAttribute("partyLeader", partyLeader);
		model.addAttribute("calcMember", calcMember);
		model.addAttribute("calcBoss", calcBoss);
		
		return "calculate/calculate";
	}
}
