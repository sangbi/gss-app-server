package com.gss.web.common.dao;

import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.common.domain.Party;
import com.gss.web.common.mapper.PartyMapper;

public class PartyDao implements PartyMapper{

	@Override
	public boolean createParty(PartyCreateDto dto) {
		
		return true;
	}

	@Override
	public boolean checkmy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Party findByEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
