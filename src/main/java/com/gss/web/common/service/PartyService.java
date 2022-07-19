package com.gss.web.common.service;

import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.common.domain.Party;

public interface PartyService {
	public int createParty(PartyCreateDto dto);
	public String  byemail(int dto);
	public Party show(int num);	
}
