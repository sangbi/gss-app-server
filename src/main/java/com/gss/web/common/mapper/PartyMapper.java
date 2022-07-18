package com.gss.web.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.common.domain.Party;

//@Mapper
public interface PartyMapper {

	public boolean createParty(PartyCreateDto dto);

	boolean checkmy();

	Party findByEmail();


}
