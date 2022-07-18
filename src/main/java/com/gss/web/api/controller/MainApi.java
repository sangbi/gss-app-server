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
	
	// gssNav.jsp ȣ��, �� ���������� nav��Ʈ�� import ���ֱ� ���� ���
	@GetMapping("/nav")
	public String GetNavPage(Model model) {
		return "main/gssNav";
	}
	
	@PostMapping("/nav")
	public String PostNavPage(Model model) {
		return "main/gssNav";
	}
	
	// gssMain.jsp ȣ��, ���� ó�� ȭ��
	@GetMapping("/home")
	public String mainPage(Model model) {
		model.addAttribute("noticeList", noticeService.getNoticeList("1"));
		return "main/gssMain";
	}
	
	// gssMain.jsp ȣ��, ������ ��ȣ�� ���� ȭ�� ȣ��
	@GetMapping("/home/{page}")
	public String mainPage(Model model, @PathVariable("page") String page) {
		model.addAttribute("noticeList", noticeService.getNoticeList(page));
		return "main/gssMain";
	}
	
	// getNoticePage.jsp ȣ��, ����ȭ�鿡�� ������ ������ �ҷ�����
	@GetMapping("/notice")
	public String getNoticePage(Model model, @RequestParam("address") String url) {
		model.addAttribute("noticesrc", noticeService.getNoticeContents(url));
		return "main/getNoticePage";
	}
}
