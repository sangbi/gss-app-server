package com.gss.web.api.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.common.domain.Member;
import com.gss.web.common.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/singup")
public class MemberApi {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(MemberApi.class);

	private final MemberServiceImpl memberServiceImpl;
	
	@GetMapping("/join")
	public String joinPageTest(Model model) {
		Member email= memberServiceImpl.findByEmail("test1@naver.com");
		model.addAttribute("email", email);
		return "join/singup";
	}
	
	@PostMapping("/join")
	public String joinMember(@RequestBody MemberCreateRequest dto) {
		String path = "";
		logger.info("[POST] :::: email : " + dto.getEmail());
		if (memberServiceImpl.checkEmail(dto.getEmail())) {
			path = "/singup/join";
		} else {
			memberServiceImpl.joinUp(dto);
			path = "/login";
		}
		System.out.println("MemberApi::::::::"+path);
		return path;
	}
}
