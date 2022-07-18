package com.gss.web.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.common.dao.PartyDao;
import com.gss.web.common.domain.Party;
import com.gss.web.common.mapper.PartyMapper;

@Service
public class PartyService implements PartyMapper{
	
	//@Autowired
	private PartyDao partydao;
	
	
	@Override
	public boolean checkmy() {
		
		return false;
	}

	@Override
	public Party findByEmail() {
		
		return null;
	}

	@Override
	public boolean createParty(PartyCreateDto dto) {
		System.out.println(dto.getPartyname());
		System.out.println(dto.getBossname());
		System.out.println(dto.getLevel());
		System.out.println(dto.getEmail());
		System.out.println(dto.getCharacter());
		
		return true;
	}

	

}
