package com.gss.web.api.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.api.dto.PartyInsertDto;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartySearchDto;
import com.gss.web.common.domain.Member;
import com.gss.web.common.service.MemberServiceImpl;
import com.gss.web.common.service.PartyPageCreatorService;
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
	public String main(Model model, PartyPageDto page, PartyPageCreatorService pc, HttpSession session,String authInfo) {
		if(session.getAttribute("authInfo")==null) {
			return "redirect:/main/home";
		}
		AuthInfo auth=  (AuthInfo) session.getAttribute("authInfo");
		Member member=memberServiceImpl.findByUserPK(auth.getUserKey());
		page.setId(member.getGssuserId());
		pc.setPaging(page);
		pc.setArticleCount(partyServiceImpl.getArticleCountNum(member.getGssuserId()));
		model.addAttribute("pc", pc);
		model.addAttribute("myParty", partyServiceImpl.showMain(page));
		model.addAttribute("myParty2", partyServiceImpl.showMain2(page));
		return "party/main";
	}

	@RequestMapping(value = "party/createparty", method = RequestMethod.GET)
	public String createParty(Model model) {
		model.addAttribute("getBossName",partyServiceImpl.getBossName());
		model.addAttribute("getBossGrade",partyServiceImpl.getBossGrade());
		return "party/createparty";
	}

	@RequestMapping(value = "party/imakeparty", method = RequestMethod.GET)
	public String imakeParty(@RequestParam("gssUserId") String gssUserId, @RequestParam("partyName") String partyName,
			Model model) {
		System.out.println(gssUserId);
		System.out.println(partyName);
		System.out.println("파티만들기 이상무");
		model.addAttribute("myParty", partyServiceImpl.getMyPartyInfo(partyName, gssUserId));
		System.out.println(partyServiceImpl.getMyPartyInfo(partyName, gssUserId));
		return "party/imakeparty";
	}

	@RequestMapping(value = "party/insert", method = RequestMethod.POST)
	public String insert(PartyCreateDto command) {
		System.out.println(command.getBossName());
		partyServiceImpl.createParty(command);
		System.out.println("파티추가이상무");
		return "redirect:/party/main";
	}

	@RequestMapping(value = "party/ienterparty", method = RequestMethod.GET)
	public String ienterParty(@RequestParam("gssUserId") String gssUserId, @RequestParam("partyName") String partyName,
			Model model) {
		System.out.println("참여한파티 이상무 ");
		model.addAttribute("ienterParty", partyServiceImpl.getIenterInfo(partyName, gssUserId));
		return "party/ienterParty";
	}
	
	@RequestMapping(value = "party/getSearchList", method = RequestMethod.GET)
	public String getSearchList(PartySearchDto searchdto, Model model,String partyName,String gssUserId){
		model.addAttribute("search",partyServiceImpl.getSearchList(searchdto));
		model.addAttribute("myParty", partyServiceImpl.getMyPartyInfo(partyName, gssUserId));
		System.out.println("안뜨나");
		return "party/imakeparty";
		
	}
	@RequestMapping(value = "party/insertPerson", method = RequestMethod.GET)
	public String insertPerson(PartyInsertDto command, Model model) {
		partyServiceImpl.insertPerson(command);
		return "redirect:/party/main";
	}
}
