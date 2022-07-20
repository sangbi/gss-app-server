package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.api.dto.CalculateMainDto;
import com.gss.web.common.service.CalculateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class CalculateApi {
	@Autowired
	private CalculateService calculateMainService;

	@GetMapping("/partyList")
	public String showMyPartyList(@RequestParam("userId") String userId, Model model) {
		int userNum = calculateMainService.selectByUserId(userId);

		List<CalculateMainDto> userList = new ArrayList<CalculateMainDto>();
		userList = calculateMainService.selectByUserNumber(userNum);
		model.addAttribute("userList", userList);

		return "calculate/calculateMain";
	}
}
