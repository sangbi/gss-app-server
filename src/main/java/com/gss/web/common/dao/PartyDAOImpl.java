package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.api.dto.MyPartyDto;
import com.gss.web.api.dto.MyPartyMember;
import com.gss.web.api.dto.PartyMainDto1;
import com.gss.web.api.dto.PartyMainDto2;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartyPageDto2;
import com.gss.web.api.dto.PartySearchDto;
import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;
import com.gss.web.common.domain.PartyInsert;
import com.gss.web.common.mapper.PartyMapper;

@Repository
public class PartyDAOImpl implements PartyDAO {
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int createParty(Party party) {
		return sqlsession.getMapper(PartyMapper.class).createParty(party);
	}

	@Override
	public int insert(MemberOfPartyTab memberOfPartyTab) {
		return sqlsession.getMapper(PartyMapper.class).insert(memberOfPartyTab);
	}

	@Override
	public int getPartyNum() {
		return sqlsession.getMapper(PartyMapper.class).getPartyNum();
	}

	@Override
	public int getUserNum(String userId) {
		return sqlsession.getMapper(PartyMapper.class).getUserNum(userId);
	}

	@Override
	public int getBossNum(@Param("bossName") String bossName, @Param("bossGrade") String bossGrade) {
		return sqlsession.getMapper(PartyMapper.class).getBossNum(bossName, bossGrade);
	}

	@Override
	public void bossHunting(int bossNum, int partyNum) {
		sqlsession.getMapper(PartyMapper.class).bossHunting(bossNum, partyNum);
	}

	@Override
	public List<PartyMainDto1> showMain(PartyPageDto page) {
		return sqlsession.getMapper(PartyMapper.class).showMain(page);
	}

	@Override
	public List<PartyMainDto2> showMain2(PartyPageDto2 page2) {
		return sqlsession.getMapper(PartyMapper.class).showMain2(page2);
	}

	@Override
	public int getPartyNumByName(String partyName) {
		return sqlsession.getMapper(PartyMapper.class).getPartyNumByName(partyName);
	}

	@Override
	public MyPartyDto getMyPartyInfo(int partyNum, String gssUserId) {
		return sqlsession.getMapper(PartyMapper.class).getMyPartyInfo(partyNum, gssUserId);
	}

	@Override
	public int getIenterNumByName(String partyName) {
		return sqlsession.getMapper(PartyMapper.class).getIenterNumByName(partyName);
	}

	@Override
	public MyPartyDto getIenterParty(int partyNum) {
		return sqlsession.getMapper(PartyMapper.class).getIenterParty(partyNum);
	}

	@Override
	public List<String> getBossName() {
		return sqlsession.getMapper(PartyMapper.class).getBossName();
	}

	@Override
	public List<String> getBossGrade() {
		return sqlsession.getMapper(PartyMapper.class).getBossGrade();
	}

	@Override
	public int getArticleCountNum(String userId) {
		return sqlsession.getMapper(PartyMapper.class).getArticleCountNum(userId);
	}

	@Override
	public int getArticleCountNum2(String userId) {
		return sqlsession.getMapper(PartyMapper.class).getArticleCountNum2(userId);
	}
	
	@Override
	public List<PartySearchDto> getSearchList (PartySearchDto searchDto) {
		return sqlsession.getMapper(PartyMapper.class).getSearchList(searchDto);
	}

	@Override
	public int insertPerson(PartyInsert partyInsert) {
		return sqlsession.getMapper(PartyMapper.class).insertPerson(partyInsert);
	}

	@Override
	public int getUserNumByName(String gssUserId) {
		return sqlsession.getMapper(PartyMapper.class).getUserNumByName(gssUserId);
	}

	@Override
	public List<String> getBossGradeList(String choiceBossName) {
		return sqlsession.getMapper(PartyMapper.class).getBossGradeList(choiceBossName);
	}

	@Override
	public List<MyPartyMember> getMyPartyMembers(int partyNum) {
		return sqlsession.getMapper(PartyMapper.class).getMyPartyMembers(partyNum);
	}
	
	@Override
	public List<Integer> getPartyListNum(String name) {
		return sqlsession.getMapper(PartyMapper.class).getPartyListNum(name);
	}
}
