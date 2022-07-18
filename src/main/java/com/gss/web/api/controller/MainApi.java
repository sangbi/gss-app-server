package com.gss.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.common.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainApi {
	private final NoticeService noticeService;
	
	// gssNav.jsp 호출, 각 페이지마다 nav파트를 import 해주기 위해 사용
	@GetMapping("/nav")
	public String navPage(Model model) {
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
	
	// gssMain.jsp 호출, 가장 처음 화면
	@GetMapping("/home")
	public String mainPage(Model model) {
		int pageCount = 1;
		int endPageCount = 510;
		
		model.addAttribute("noticeList", noticeService.getNoticeList("1"));
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("endPageCount", endPageCount);
		
		return "main/gssMain";
	}
	
	// gssMain.jsp 호출, 페이지 번호에 따른 화면 호출
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
	
	// getNoticePage.jsp 호출, 메인화면에서 선택한 페이지 불러오기
	@GetMapping("/notice")
	public String getNoticePage(Model model, @RequestParam("address") String url) {
		model.addAttribute("noticesrc", noticeService.getNoticeContents(url));
		return "main/getNoticePage";
	}
}
