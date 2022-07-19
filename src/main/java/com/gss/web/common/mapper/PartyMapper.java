package com.gss.web.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;

@Mapper
public interface PartyMapper {
	public int createParty(Party party);

	public void insert(MemberOfPartyTab memberofpartytab);

	Party findByEmail();
}
