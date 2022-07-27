package com.gss.web.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.common.domain.Member;
import com.gss.web.common.service.MemberServiceImpl;
import com.gss.web.common.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainApi {
	@Autowired
	private final MemberServiceImpl memberServiceImpl;
	
	private final NoticeService noticeService;
	
	@GetMapping("/nav")
	public String GetNavPage(Model model, HttpSession session) {

		return "main/gssNav";
	}
	
	@GetMapping("/bottom")
	public String bottomPage() {
		return "main/gssBottom";
	}
	
	@PostMapping("/bottom")
	public String postBottomPage() {
		return "main/gssBottom";
	}
  
	@PostMapping("/nav")
	public String PostNavPage(Model model) {
		return "main/gssNav";
	}

	@GetMapping("/home")
	public String mainPage(Model model) {
		int pageCount = 1;
		int endPageCount = 510;
		
		model.addAttribute("noticeList", noticeService.getNoticeList("1"));
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("endPageCount", endPageCount);
		
		return "main/gssMain";
	}
	@PostMapping("/home")
	public String PostMainPage(Model model) {
		int pageCount = 1;
		int endPageCount = 510;
		
		model.addAttribute("noticeList", noticeService.getNoticeList("1"));
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("endPageCount", endPageCount);
		
		return "main/gssMain";
	}
	@GetMapping("/home/page={page}")
	public String mainPage(Model model, @PathVariable("page") String page) {
		int pageCount = 1;
		int endPageCount = 510;
		pageCount = Integer.parseInt(page);

		model.addAttribute("noticeList", noticeService.getNoticeList(page));
		model.addAttribute("page", page);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("endPageCount", endPageCount);
		
		return "main/gssMain";
	}
	
	@GetMapping("/notice")
	public String getNoticePage(Model model, @RequestParam("address") String url) {
		model.addAttribute("noticesrc", noticeService.getNoticeContents(url));
		return "main/getNoticePage";
	}
}
