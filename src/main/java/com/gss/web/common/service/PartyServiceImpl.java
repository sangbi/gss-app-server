package com.gss.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.MyPartyDto;
import com.gss.web.api.dto.MyPartyMember;
import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.api.dto.PartyInsertDto;
import com.gss.web.api.dto.PartyMainDto1;
import com.gss.web.api.dto.PartyMainDto2;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartyPageDto2;
import com.gss.web.api.dto.PartySearchDto;
import com.gss.web.common.dao.PartyDAOImpl;
import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;
import com.gss.web.common.domain.PartyInsert;

@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyDAOImpl partyDaoImpl;

	@Override
	public int createParty(PartyCreateDto dto) {
		boolean leader = true;
		Party party = new Party(dto.getPartyName());
		partyDaoImpl.createParty(party);
		partyDaoImpl.bossHunting(partyDaoImpl.getBossNum(dto.getBossName(), dto.getLevel()),
				partyDaoImpl.getPartyNum());
		MemberOfPartyTab memberOfPartyTab = new MemberOfPartyTab(partyDaoImpl.getPartyNum(),
				partyDaoImpl.getUserNum(dto.getId()), dto.getCharaterName(), leader);

		return partyDaoImpl.insert(memberOfPartyTab);
	}

	@Override
	public List<PartyMainDto1> showMain(PartyPageDto page) {
		return partyDaoImpl.showMain(page);
	}

	@Override
	public List<PartyMainDto2> showMain2(PartyPageDto2 page2) {
		return partyDaoImpl.showMain2(page2);
	}

	@Override
	public MyPartyDto getMyPartyInfo(String partyName, String gssUserId) {
		return partyDaoImpl.getMyPartyInfo(partyDaoImpl.getPartyNumByName(partyName), gssUserId);

	}

	@Override
	public MyPartyDto getIenterInfo(String partyName) {
		return partyDaoImpl.getIenterParty(partyDaoImpl.getIenterNumByName(partyName));
	}

	@Override
	public List<String> getBossName() {
		return partyDaoImpl.getBossName();
	}

	@Override
	public List<String> getBossGrade() {
		return partyDaoImpl.getBossGrade();
	}

	@Override
	public int getArticleCountNum(String userId) {
		return partyDaoImpl.getArticleCountNum(userId);
	}

	@Override
	public int getArticleCountNum2(String userId) {
		return partyDaoImpl.getArticleCountNum2(userId);
	}
	
	@Override
	public List<PartySearchDto> getSearchList(PartySearchDto searchDto) {
		return partyDaoImpl.getSearchList(searchDto);
	}

	@Override
	public int insertPerson(PartyInsertDto partyInsertDto) {
		System.out.println(partyInsertDto.getInsertId());
		int usernum = partyDaoImpl.getUserNumByName(partyInsertDto.getInsertId());
		int partynum = partyDaoImpl.getPartyNumByName(partyInsertDto.getPartyName());
		boolean flat = false;
		PartyInsert partyInsert = new PartyInsert(usernum, partynum, partyInsertDto.getCharaterName(), flat);
		return partyDaoImpl.insertPerson(partyInsert);
	}

	@Override
	public List<String> getBossGradeList(String choiceBossName) {
		return partyDaoImpl.getBossGradeList(choiceBossName);
	}

	@Override
	public List<MyPartyMember> getMyPartyMembers(String partyName) {
		return partyDaoImpl.getMyPartyMembers(partyDaoImpl.getPartyNumByName(partyName));
	}

	

}