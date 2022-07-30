package com.gss.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.api.dto.PartyInsertDto;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartyPageDto2;
import com.gss.web.api.dto.PartySearchDto;
import com.gss.web.common.domain.Member;
import com.gss.web.common.service.MemberServiceImpl;
import com.gss.web.common.service.PartyPageCreatorService;
import com.gss.web.common.service.PartyPageCreatorServiceDown;
import com.gss.web.common.service.PartyServiceImpl;

@Controller
public class PartyApi {
	private PartyServiceImpl partyServiceImpl;
	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@Autowired
	public void setPartyService(PartyServiceImpl partyserviceimpl) {
		this.partyServiceImpl = partyserviceimpl;

	}

	@RequestMapping(value = "party/main", method = RequestMethod.GET)
	public String main(Model model, PartyPageDto page, PartyPageCreatorService pc, HttpSession session,
			String authInfo,PartyPageCreatorServiceDown pc2, PartyPageDto2 page2) {
		if (session.getAttribute("authInfo") == null) {
			return "redirect:/main/home";
		}
		AuthInfo auth = (AuthInfo) session.getAttribute("authInfo");
		Member member = memberServiceImpl.findByUserPK(auth.getUserKey());
		page.setId(member.getGssuserId());
		page2.setId(member.getGssuserId());
		pc.setPaging(page);
		pc2.setPaging(page2);
		pc.setArticleCount(partyServiceImpl.getArticleCountNum(member.getGssuserId()));
		pc2.setArticleCount(partyServiceImpl.getArticleCountNum2(member.getGssuserId()));
		model.addAttribute("pc1", pc);
		model.addAttribute("pc2", pc2);
		model.addAttribute("myParty", partyServiceImpl.showMain(page));
		model.addAttribute("myParty2", partyServiceImpl.showMain2(page2));
		return "party/main";
	}

	@PostMapping("/bossGradeList")
	@ResponseBody
	public List<String> bossGradeList(String choiceBossName) {
		List<String> gradeList = new ArrayList<String>();
		gradeList = partyServiceImpl.getBossGradeList(choiceBossName);
		return gradeList;
	}

	@RequestMapping(value = "party/createparty", method = RequestMethod.GET)
	public String createParty(Model model) {
		model.addAttribute("getBossName", partyServiceImpl.getBossName());
		model.addAttribute("getBossGrade", partyServiceImpl.getBossGrade());
		return "party/createparty";
	}

	@RequestMapping(value = "party/imakeparty", method = RequestMethod.GET)
	public String imakeParty(@RequestParam("gssUserId") String gssUserId, @RequestParam("partyName") String partyName,
			Model model) {
		model.addAttribute("myParty", partyServiceImpl.getMyPartyInfo(partyName, gssUserId));
		model.addAttribute("myMember", partyServiceImpl.getMyPartyMembers(partyName));
		return "party/imakeparty";
	}

	@RequestMapping(value = "party/insert", method = RequestMethod.POST)
	public String insert(PartyCreateDto command) {
		partyServiceImpl.createParty(command);
		return "redirect:/party/main";
	}

	@RequestMapping(value = "party/ienterparty", method = RequestMethod.GET)
	public String ienterParty(@RequestParam("gssUserId") String gssUserId, @RequestParam("partyName") String partyName,
			Model model) {
		
		model.addAttribute("ienterParty", partyServiceImpl.getIenterInfo(partyName));
		model.addAttribute("myMember", partyServiceImpl.getMyPartyMembers(partyName));
		return "party/ienterparty";
	}

	@RequestMapping(value = "party/getSearchList", method = RequestMethod.GET)
	public String getSearchList(PartySearchDto searchdto, Model model, String partyName, String gssUserId) {
		model.addAttribute("search", partyServiceImpl.getSearchList(searchdto));
		model.addAttribute("myParty", partyServiceImpl.getMyPartyInfo(partyName, gssUserId));
		model.addAttribute("myMember", partyServiceImpl.getMyPartyMembers(partyName));
		return "party/imakeparty";

	}

	@RequestMapping(value = "party/insertPerson", method = RequestMethod.GET)
	public String insertPerson(PartyInsertDto command, Model model,@RequestParam("gssUserId")String gssUserId) {
		System.out.println(command.getInsertId());
		System.out.println(command.getPartyName());
		System.out.println(command.getCharaterName());
		partyServiceImpl.insertPerson(command);
		model.addAttribute("myParty", partyServiceImpl.getMyPartyInfo(command.getPartyName(),gssUserId));
		model.addAttribute("myMember", partyServiceImpl.getMyPartyMembers(command.getPartyName()));
		return "party/imakeparty";
	}
	
	
}
