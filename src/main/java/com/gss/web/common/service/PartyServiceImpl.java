package com.gss.web.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.common.dao.PartyDaoImpl;
import com.gss.web.common.domain.Party;

@Service
public class PartyServiceImpl implements PartyService{
	int i=0;
	@Autowired
	private PartyDaoImpl partydao;

	@Override
	public int createParty(PartyCreateDto dto) {
		Party party = new Party (i++,dto.getPartyname());
		
		//MemberOfPartyTab memberofpartytab = new MemberOfPartyTab(i++,i++,dto.getCharacter(),dto.getEmail());
		//partydao.insert(memberofpartytab);
		return partydao.createParty(party);
	}

	@Override
	public String byemail(int dto) {
		return null;
	}

	@Override
	public Party show(int num) {
		return null;
	}
}
