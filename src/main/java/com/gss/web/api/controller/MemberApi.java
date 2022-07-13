package com.gss.web.api.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.common.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/singup")
public class MemberApi {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(MemberApi.class);

	private final MemberService memberService;

	@PostMapping("/join")
	public String joinMember(@RequestBody MemberCreateRequest dto) {
		String path = "";
		logger.info("[POST] :::: email : " + dto.getEmail());
		if (memberService.checkEmail(dto.getEmail())) {
			path = "/singup/join";
		} else {
			memberService.joinUp(dto);
			path = "/login";
		}
		System.out.println("MemberApi::::::::"+path);
		return path;
	}
}
