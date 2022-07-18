package com.gss.web.api.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.common.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {

	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@GetMapping("/join")
	public String joinPageTest(@ModelAttribute("MemberCreateDto") MemberCreateDto memberCreateDto) {
		return "/join/singup";
	}

	@PostMapping("/join")
	public String joinMember(@ModelAttribute("MemberCreateDto") @Valid MemberCreateDto MCRdto, BindingResult result, Model model) {
		String path = "";
		Map<String, String> validatorResult = memberServiceImpl.validateNullandEmptyCheck(MCRdto);
		if (!validatorResult.isEmpty()) {
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			if (result.hasErrors()) {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.validateHandling(result);
				for (String key : validatorResult.keySet()) {
					if(model.getAttribute(key)==null) {
						model.addAttribute(key, validatorResult.get(key));
					}
				}
				path = "join/singup";
			}
		}else {
			if (result.hasErrors()) {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.validateHandling(result);
				for (String key : validatorResult.keySet()) {
					model.addAttribute(key, validatorResult.get(key));
				}
				path = "join/singup";
			} else {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult =memberServiceImpl.checkEmailandEmail(MCRdto);
				if(!validatorResult.isEmpty()) {
					for (String key : validatorResult.keySet()) {
						model.addAttribute(key, validatorResult.get(key));
					}
					path = "join/singup";
				}else {
					memberServiceImpl.joinUp(MCRdto);
					path="/login/login";
				}
			}
		}
		return path;
	}

	@GetMapping("/login")
	public String loginMember() {
		return "/login/login";
	}
}
