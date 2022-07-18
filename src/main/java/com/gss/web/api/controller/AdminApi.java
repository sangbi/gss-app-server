package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.gss.web.api.dto.BossDto;
import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.service.BossService;
import com.gss.web.common.service.FileService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminApi {
	@Autowired
	private FileService fileService; 
	
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
		System.out.println("보스 페이지");
		return "/admin/boss/bossList";
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String insertBoss(@ModelAttribute("BossDto") BossDto bossDto) {
//		String urlPath = "";
//			MultipartFile file = bossDto.getBossImagepath();
//			String path = fileService.fileUpload(file, path);
//			if (!path.equals("")) {
//				try {
//					bossDto.setBossImagepath(path);
//					BossService(bossDto);
//					System.out.println("upload su");
//				} catch (AlreadyExistingBookException e) {
//					System.out.println("upload fail");
//					errors.rejectValue("isbn", "duplicate");
//					urlPath = "lib/book_reg_form";
//				}
//				urlPath = "redirect:/list";
//			} else {
//				System.out.println("실패");
//				urlPath = "lib/book_reg_form";
//			}
//		}

	// ---------------------------------------------------------

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
