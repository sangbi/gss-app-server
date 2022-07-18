package com.gss.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.common.service.PartyService;

@Controller
public class PartyApi {
	
	private PartyService partyservice;
	
	@Autowired
	public void setPartyService(PartyService partyservice) {
			
		this. partyservice= partyservice;}
				
			

	@RequestMapping(value = "party/main", method = RequestMethod.GET)
	public void main() {

		System.out.println("메인이상무");

	}

	@RequestMapping(value = "party/createparty", method = RequestMethod.GET)
	public String createParty() {

		System.out.println("파티생성 이상무 ");
		return "party/createparty";

	}

	@RequestMapping(value = "party/imakeparty", method = RequestMethod.GET)
	public String imakeParty() {

		System.out.println("파티만들기 이상무");
		return "party/imakeparty";

	}

	@RequestMapping(value = "party/insert", method = RequestMethod.POST)
	public String insert(PartyCreateDto command) {
		System.out.println(command.getBossname());
		partyservice.createParty(command);
		System.out.println("파티추가이상무");
		return "party/main";

	}

	@RequestMapping(value = "party/ienterparty", method = RequestMethod.GET)
	public String ienterparty() {

		System.out.println("참여한파티 이상무 ");
		return "party/ienterparty";

	}
}
