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
	
	// getNoticePage.jsp ȣ��, ����ȭ�鿡�� ������ ������ �ҷ�����
	@GetMapping("/notice")
	public String getNoticePage(Model model, @RequestParam("address") String url) {
		model.addAttribute("noticesrc", noticeService.getNoticeContents(url));
		return "main/getNoticePage";
	}
}
