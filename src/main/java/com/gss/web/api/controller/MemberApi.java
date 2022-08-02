package com.gss.web.api.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.LoginDto;
import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.api.vo.NaverLoginProfile;
import com.gss.web.api.vo.NaverLoginVo;
import com.gss.web.common.domain.Member;
import com.gss.web.common.domain.MyInfoList;
import com.gss.web.common.service.AuthService;
import com.gss.web.common.service.MailService;
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
	
	@Autowired
	private MailService mailService;
	
	private List<Map<String, String>> certifyCationEmailPass = new ArrayList<Map<String, String>>();
	
	private static final String SESSION_COOKIE_NAME = "userSessionId";

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
				//validatorResult = memberServiceImpl.checkEmailandIDandPhoneNum(MCRdto);
				for (String key : validatorResult.keySet()) {
					if (model.getAttribute(key) == null) {
						model.addAttribute(key, validatorResult.get(key));
					}
				}
				validatorResult = memberServiceImpl.checkEmailandIDandPhoneNum(MCRdto);
				for (String key : validatorResult.keySet()) {
					if (model.getAttribute(key) == null) {
						model.addAttribute(key, validatorResult.get(key));
					}
				}
				path = "/join/singup";
			}else {
				
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
				validatorResult = memberServiceImpl.checkEmailandIDandPhoneNum(MCRdto);
				if (!validatorResult.isEmpty()) {
					for (String key : validatorResult.keySet()) {
						model.addAttribute(key, validatorResult.get(key));
					}
					path = "/join/singup";
				} else {
					memberServiceImpl.joinUp(MCRdto);
					path="/join/singupend";
					//path = "redirect:/member/joinend";
				}
			}
		}
		return path;
	}
	
	@GetMapping("/joinend")
	public String joinEnd() {
		return "/join/singupend";
	}

	// 로그인 페이지
	@GetMapping("/login")
	public String loginMemberGet(@ModelAttribute("LoginDto") LoginDto loginDto,
			@CookieValue(value = "REMEBER", required = false) Cookie cookie,HttpSession session) {
		if(session.getAttribute("authInfo")!=null) {
			return "redirect:../main/home";
		}
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
		AuthInfo authiInfo;
		if(session.getAttribute("authiInfo")!=null) {
			return "/main/home";
		}
		if (result.hasErrors()) {
			Map<String, String> validatorResult = memberServiceImpl.validateHandling(result);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			path = "/login/login";
		} else {
			try {
				authiInfo = authService.authenticate(loginDto.getUserid(), loginDto.getPassword());
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
	
	@GetMapping("/myMain")
	public String myMainPage(@ModelAttribute("MemberCreateDto")MemberCreateDto MCDto,Model model,HttpSession session) {
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}
		AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
		Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
		List<MyInfoList> MIL=memberServiceImpl.findByMyInfoList(auth.getUserKey());
		List<MyInfoList> MILMember=memberServiceImpl.findByMyInfoListMember(auth.getUserKey());
		model.addAttribute("member",member);
		model.addAttribute("MIL",MIL);
		model.addAttribute("MILMember",MILMember);
		return "mypage/myinfo";
	}
	
	@GetMapping("/mypage")
	public String myPage(@ModelAttribute("MemberCreateDto")MemberCreateDto MCDto,HttpSession session,Model model) {
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}
		AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
		Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
		model.addAttribute(member);
		return "/mypage/mypage";
	}
	
	@PostMapping("/mypage")
	public String PostMyPage(@ModelAttribute("MemberCreateDto") @Valid MemberCreateDto MCRdto, BindingResult result,
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
				//validatorResult = memberServiceImpl.checkEmailandIDandPhoneNum(MCRdto);
				for (String key : validatorResult.keySet()) {
					if (model.getAttribute(key) == null) {
						model.addAttribute(key, validatorResult.get(key));
					}
				}
				validatorResult = memberServiceImpl.checkIDandPhoneNum(MCRdto);
				for (String key : validatorResult.keySet()) {
					if (model.getAttribute(key) == null) {
						model.addAttribute(key, validatorResult.get(key));
					}
				}
				path = "/mypage/mypage";
			}
			path = "/mypage/mypage";
		} else {
			if (result.hasErrors()) {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.validateHandling(result);
				for (String key : validatorResult.keySet()) {
					model.addAttribute(key, validatorResult.get(key));
				}
				path = "/mypage/mypage";
			} else {
				model.addAttribute("MCRdto", MCRdto);
				validatorResult = memberServiceImpl.checkIDandPhoneNum(MCRdto);
				if (!validatorResult.isEmpty()) {
					for (String key : validatorResult.keySet()) {
						model.addAttribute(key, validatorResult.get(key));
					}
					path = "/mypage/mypage";
				} else {
					memberServiceImpl.editUserInfo(MCRdto);
					path="redirect:/member/editEnd";
				}
			}
		}
		return path;
	}

	@GetMapping("/editMyPartyNick")
	public String editMyPartyNick(@RequestParam String partyName,@RequestParam String charaterNick, Model model,HttpSession session) {
		String charaterName=charaterNick;
		String path;
		AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
		int gssUserNum=Integer.valueOf(auth.getUserKey());
		Map<String, String> validatorResult = new HashMap<>();
		MyInfoList MIL= new MyInfoList(partyName, charaterName,gssUserNum);
		validatorResult=memberServiceImpl.ValidCheckPartyNick(MIL,charaterName);
		if (!validatorResult.isEmpty()) {
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			path = "redirect:/member/myMain";
		} else {
			memberServiceImpl.updatePartyNick(MIL);
			path="redirect:/member/myMain";
		}
		
		model.addAttribute("partyName",partyName);
		model.addAttribute("charaterName",charaterName);
		return path;
	}
	
	@GetMapping("/editEnd")
	public String editEnd(HttpSession session) {
		session.invalidate();
		return "/mypage/editmyinfoend";
	}
	
	@PostMapping("/email")
	@ResponseBody
	public void confirmEmail(String userEmail) {
		String randomNumber=mailService.sendMail(userEmail);
		Map<String, String>map= new HashMap<String, String>();
		map.put(userEmail, randomNumber);
		certifyCationEmailPass.add(map);
	}
	
	@PostMapping("/cerEmail")
	@ResponseBody
	public String certificationEmail(String cerNumber, String inputEmail) {
		String result="";
		 for(int i=0; i<certifyCationEmailPass.size(); i++) {
			 Map<String, String>tempMap=certifyCationEmailPass.get(i);
			 Map<String, String>insertValueMap= new HashMap<String, String>();
			 insertValueMap.put(inputEmail, cerNumber);
			 if(tempMap.equals(insertValueMap)) {
				 result="true";
				 certifyCationEmailPass.remove(i);
				 break;
			 }else {
				 result="false"; 
			 }
		 }
		return result;
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/main/home";
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
		for (int i = 0; i < 8; i++) {

			idx = (int) (charSet.length * Math.random()); // 36 * 생성된 난수를 Int로 추출 (소숫점제거)
			sb.append(charSet[idx]);
		}

		return sb.toString();
	}
}
