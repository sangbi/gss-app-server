package com.gss.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// gssMain.jsp 호출, 가장 처음 화면
	@GetMapping("/home")
	public String mainPage(Model model) {
		model.addAttribute("noticeList", noticeService.getNoticeList("1"));
		return "main/gssMain";
	}
	
	// gssMain.jsp 호출, 페이지 번호에 따른 화면 호출
	@GetMapping("/home/{page}")
	public String mainPage(Model model, @PathVariable("page") String page) {
		model.addAttribute("noticeList", noticeService.getNoticeList(page));
		return "main/gssMain";
	}
	
	// getNoticePage.jsp 호출, 메인화면에서 선택한 페이지 불러오기
	@GetMapping("/notice")
	public String getNoticePage(Model model, @RequestParam("address") String url) {
		model.addAttribute("noticesrc", noticeService.getNoticeContents(url));
		return "main/getNoticePage";
	}
}
