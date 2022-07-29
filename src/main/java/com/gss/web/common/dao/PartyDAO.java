package com.gss.web.common.dao;

import java.util.List;

import com.gss.web.api.dto.MyPartyDto;
import com.gss.web.api.dto.PartyInsertDto;
import com.gss.web.api.dto.PartyMainDto1;
import com.gss.web.api.dto.PartyMainDto2;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartySearchDto;
import com.gss.web.common.domain.MemberOfPartyTab;
import com.gss.web.common.domain.Party;
import com.gss.web.common.domain.PartyInsert;

public interface PartyDAO {

	public int getArticleCountNum(String userId);

	public int createParty(Party party);

	public int insert(MemberOfPartyTab memberOfOartyBab);

	public void bossHunting(int bossnum, int partynum);

	public int getPartyNum();

	public int getUserNum(String userid);

	public int getBossNum(String bossName, String bossGrade);

	public List<PartyMainDto1> showMain(PartyPageDto page);

	public List<PartyMainDto2> showMain2(PartyPageDto page);

	public int getPartyNumByName(String partyName);

	public MyPartyDto getMyPartyInfo(int partyNum, String gssUserId);

	public int getIenterNumByName(String partyName);

	public MyPartyDto getIenterParty(int partyNum, String gssUserId);

	public List<String> getBossName();

	public List<String> getBossGrade();
	
	public List<PartySearchDto> getSearchList(PartySearchDto searchDto);
	
	public int insertPerson (PartyInsert partyInsert);
	
	public int getUserNumByName (String gssUserId);
	
	public List<String> getBossGradeList(String choiceBossName);
}
