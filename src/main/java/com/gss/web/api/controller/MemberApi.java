package com.gss.web.api.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.LoginDto;
import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.common.service.AuthService;
import com.gss.web.common.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	@Autowired
	private AuthService authService;
	
	//회원가입 GET요청
	@GetMapping("/join")
	public String joinPageTest(@ModelAttribute("MemberCreateDto") MemberCreateDto memberCreateDto) {
		return "/join/singup";
	}
	
	//회원가입 POST요청
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
				path = "/join/singup";
			}
		}else {
			if (result.hasErrors()) {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.validateHandling(result);
				for (String key : validatorResult.keySet()) {
					model.addAttribute(key, validatorResult.get(key));
				}
				path = "/join/singup";
			} else {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult =memberServiceImpl.checkEmailandEmail(MCRdto);
				if(!validatorResult.isEmpty()) {
					for (String key : validatorResult.keySet()) {
						model.addAttribute(key, validatorResult.get(key));
					}
					path = "/join/singup";
				}else {
					memberServiceImpl.joinUp(MCRdto);
					path="/login/login";
				}
			}
		}
		return path;
	}
	//로그인 페이지
	@GetMapping("/login")
	public String loginMemberGet(@ModelAttribute("LoginDto")LoginDto loginDto,@CookieValue(value = "REMEBER", required = false) Cookie cookie) {
		if(cookie !=null) {
			loginDto.setUserid(cookie.getValue());
			loginDto.setRememberUserid(true);
		}
		return "/login/login";
	}
	
	@PostMapping("/login")
	public String loginMemberPost(@ModelAttribute("LoginDto")@Valid LoginDto loginDto, BindingResult result,HttpSession session, HttpServletResponse response,Model model) {
		String path="";
		if(result.hasErrors()) {
			Map<String, String> validatorResult = authService.validateHandling(result);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			path= "/login/login";
		}else {
			try {
			AuthInfo authiInfo=authService.authenticate(loginDto.getUserid(), loginDto.getPassword());
			session.setAttribute("authInfo", authiInfo);
			Cookie rememberCookie= new Cookie("REMEBER", loginDto.getUserid());
			rememberCookie.setPath("/");
			
			if(loginDto.isRememberUserid()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			path= "main/gssMain";
			}catch(Exception e) {
				model.addAttribute("idpasswordNotMatch","ID와 Password가 일치하지 않습니다.");
				return "/login/login";
			}
		}
		return path;
	}
}
