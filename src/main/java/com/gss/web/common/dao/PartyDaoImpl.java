package com.gss.web.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;
import com.gss.web.common.mapper.PartyMapper;
@Repository
public class PartyDaoImpl implements PartyDao{
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int createParty(Party party) {		
		System.out.println(party.getPartynum());
		System.out.println(party.getPartyname());
		return sqlsession.getMapper(PartyMapper.class).createParty(party);
	}

	@Override
	public Party show(int num) {
		return null;
	}

	@Override
	public void insert(MemberOfPartyTab memberofpartytab) {
		System.out.println(memberofpartytab.getCharatername());
		//return sqlsession.getMapper(PartyMapper.class).insert(memberofpartytab);
	}
}
