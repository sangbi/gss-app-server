package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.gss.web.api.dto.BossDto;
import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.domain.Boss;
import com.gss.web.common.service.BossServiceImpl;
import com.gss.web.common.service.FileService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminApi {
	@Autowired
	private FileService fileService;
	@Autowired
	private BossServiceImpl bossServiceImpl;

	// 관리자 메인
	@GetMapping("/main")
	public String adminMain() {
		System.out.println("관리자 메인");
		return "admin/adminMain";
	}

	// 보스정보 등록 리스트페이지
	@GetMapping("/boss")
	public String adminBoss(Model model) {
		List<BossDto> bossList = new ArrayList<>();
		model.addAttribute("bossList", bossList);
		return "/admin/boss/bossList";
	}

	@GetMapping("/addBoss")
	public String insertBoss(@ModelAttribute("BossDto") BossDto bossDto) {
		return "/admin/boss/insertBoss";
	}
	
	@PostMapping("/addBoss")
	public String insertBossReq(@ModelAttribute("BossDto") BossDto bossDto, HttpServletRequest req) {
		String uploadPath = req.getSession().getServletContext().getRealPath("/").concat("resources"+"\\"+"bossImage");
		String urlPath = "";
		Boss boss;
		MultipartFile file = bossDto.getBossImagepath();
		String fileName=file.getOriginalFilename();
		String path = fileService.fileUpload(file, fileName,uploadPath);
			if (!path.equals("")) {
					boss=new Boss(bossDto.getBossName(),path,bossDto.getBossGrade());
					urlPath=bossServiceImpl.bossExistence(boss);
					System.out.println("1111111111111111111"+urlPath);
			} else {
				urlPath = "admin/boss";
			}
		return urlPath;
	}

	// 선택한보스 정보페이지
	@GetMapping("/boss/select")
	public String read(Model model, HttpServletRequest req) {
		BossDto bossDto = new BossDto();
		bossDto.setBossName("bossName");
		model.addAttribute("bossDto");
		return "/admin/boss/selectByBoss";
	}

	// 아이템정보 등록
	@GetMapping("/item")
	public String adminItem(Model model) {
		List<ItemDto> itemList = new ArrayList<>();
		model.addAttribute("itemList", itemList);
		System.out.println("아이템 페이지");
		return "/admin/item/itemList";
	}

	// 보스별 드랍아이템 추가
	@GetMapping("/bossAndDrop")
	public String adminDrop() {
		System.out.println("보스별 드랍");
		return "/admin/bossAndDrop/dropBossList";
	}
}
