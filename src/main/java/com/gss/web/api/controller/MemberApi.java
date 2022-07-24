package com.gss.web.api.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.LoginDto;
import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.api.vo.NaverLoginProfile;
import com.gss.web.api.vo.NaverLoginVo;
import com.gss.web.common.service.AuthService;
import com.gss.web.common.service.MemberServiceImpl;
import com.gss.web.common.service.NaverLoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {
	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@Autowired
	private NaverLoginService service;
	
	@Autowired
	private AuthService authService ;

	// 회원가입 GET요청
	@GetMapping("/join")
	public String joinPageTest(@ModelAttribute("MemberCreateDto") MemberCreateDto memberCreateDto) {
		return "/join/singup";
	}

	// 회원가입 POST요청
	@PostMapping("/join")
	public String joinMember(@ModelAttribute("MemberCreateDto") @Valid MemberCreateDto MCRdto, BindingResult result,
			Model model) {
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
					if (model.getAttribute(key) == null) {
						model.addAttribute(key, validatorResult.get(key));
					}
				}
				path = "/join/singup";
			}
			path = "/join/singup";
		} else {
			if (result.hasErrors()) {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.validateHandling(result);
				for (String key : validatorResult.keySet()) {
					model.addAttribute(key, validatorResult.get(key));
				}
				path = "/join/singup";
			} else {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.checkEmailandEmail(MCRdto);
				if (!validatorResult.isEmpty()) {
					for (String key : validatorResult.keySet()) {
						model.addAttribute(key, validatorResult.get(key));
					}
					path = "/join/singup";
				} else {
					memberServiceImpl.joinUp(MCRdto);
					path = "/join/singupend";
				}
			}
		}
		return path;
	}

	// 로그인 페이지
	@GetMapping("/login")
	public String loginMemberGet(@ModelAttribute("LoginDto") LoginDto loginDto,
			@CookieValue(value = "REMEBER", required = false) Cookie cookie) {
		if (cookie != null) {
			loginDto.setUserid(cookie.getValue());
			loginDto.setRememberUserid(true);
		}
		return "/login/login";
	}

	@PostMapping("/login")
	public String loginMemberPost(Principal principal, @ModelAttribute("LoginDto") @Valid LoginDto loginDto,
			BindingResult result, HttpSession session, HttpServletResponse response, Model model) {
		String path = "";
		if (result.hasErrors()) {
			Map<String, String> validatorResult = memberServiceImpl.validateHandling(result);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			path = "/login/login";
		} else {
			try {
				AuthInfo authiInfo = authService.authenticate(loginDto.getUserid(), loginDto.getPassword());
				session.setAttribute("authInfo", authiInfo);
				Cookie rememberCookie = new Cookie("REMEBER", loginDto.getUserid());
				rememberCookie.setPath("/");

				if (loginDto.isRememberUserid()) {
					rememberCookie.setMaxAge(60 * 60 * 24 * 30);
				} else {
					rememberCookie.setMaxAge(0);
				}
				response.addCookie(rememberCookie);
				path = "redirect:../main/home";
			} catch (Exception e) {
				model.addAttribute("idpasswordNotMatch", "ID와 Password가 일치하지 않습니다.");
				return "login/login";
			}
		}
		return path;
	}

	@GetMapping("/login/oauth2/code/naver")
	public String loginNaver(@RequestParam Map<String, String> resValue, HttpSession session,
			HttpServletResponse response) {
		// code 를 받아오면 code 를 사용하여 access_token를 발급받는다.
		final NaverLoginVo naverLoginVo = service.requestNaverLoginAcceccToken(resValue, "authorization_code");
		String tempPassword = getRamdomPassword();
		// access_token를 사용하여 사용자의 고유 id값을 가져온다.
		final NaverLoginProfile naverLoginProfile = service.requestNaverLoginProfile(naverLoginVo);
		int lastUserSEQ = memberServiceImpl.selectLastUserSEQ();
		MemberCreateDto memberDto = new MemberCreateDto(naverLoginProfile.getName(),
				(naverLoginProfile.getName() + (lastUserSEQ + 1)), naverLoginProfile.getEmail(), tempPassword,
				naverLoginProfile.getPhoneNumber());

		if (!memberServiceImpl.checkEmail(naverLoginProfile.getEmail())) {
			memberServiceImpl.joinUp(memberDto);
		}
		AuthInfo authiInfo = authService.authenticateEmail(memberDto.getEmail());
		session.setAttribute("authInfo", authiInfo);

		return "/login/naverlogin";
	}

	@GetMapping("/login/oauth2/code/naver/close")
	public String closeNaverPopup() {
		return "/login/naverlogin";
	}

	public String getRamdomPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		int idx = 0;
		StringBuffer sb = new StringBuffer();

		System.out.println("charSet.length :::: " + charSet.length);

		for (int i = 0; i < 8; i++) {

			idx = (int) (charSet.length * Math.random()); // 36 * 생성된 난수를 Int로 추출 (소숫점제거)
			System.out.println("idx :::: " + idx);
			sb.append(charSet[idx]);
		}

		return sb.toString();
	}
}
