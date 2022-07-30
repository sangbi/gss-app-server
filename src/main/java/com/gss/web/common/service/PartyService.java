package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.MyPartyDto;
import com.gss.web.api.dto.MyPartyMember;
import com.gss.web.api.dto.PartyCreateDto;
import com.gss.web.api.dto.PartyInsertDto;
import com.gss.web.api.dto.PartyMainDto1;
import com.gss.web.api.dto.PartyMainDto2;
import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartyPageDto2;
import com.gss.web.api.dto.PartySearchDto;

public interface PartyService {

	public int createParty(PartyCreateDto dto);

	public List<PartyMainDto1> showMain(PartyPageDto page);

	public List<PartyMainDto2> showMain2(PartyPageDto2 page);

	public List<String> getBossName();

	public List<String> getBossGrade();

	public MyPartyDto getMyPartyInfo(String partyName, String gssUserId);

	public MyPartyDto getIenterInfo(String partyName);

	public int getArticleCountNum(String userId);

	public int getArticleCountNum2(String userId);

	public List<PartySearchDto> getSearchList(PartySearchDto searchDto);

	public int insertPerson(PartyInsertDto partyInsertdto);

	public List<String> getBossGradeList(String choiceBossName);
	
	List<MyPartyMember> getMyPartyMembers(String partyName);
}
