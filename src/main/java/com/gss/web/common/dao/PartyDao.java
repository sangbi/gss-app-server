package com.gss.web.common.dao;

import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;

public interface PartyDao {
	public int createParty(Party party);
	
	public void insert(MemberOfPartyTab memberofpartytab);
	
	public Party show(int num);
}
