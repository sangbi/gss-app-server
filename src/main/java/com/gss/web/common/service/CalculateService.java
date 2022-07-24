package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.PartyGetItem;

public interface CalculateService {
	public List<CalculateMain> selectByUserNumber(int userNum);
	
	public int selectByUserId(String userId);

	public int selectCountMember(String partyName);
	
	public String selectPartyLeader(String partyName);
	
	public List<Calculate> selectPartyMember(String partyName);
	
	public List<Calculate> selectBossNameAndGrade(String partyName);
	
	public List<PartyGetItem> selectItemNameAndPrice(String partyName);
	
	public int insertItemNameAndPrice(PartyGetItemDto pgiDto);
}
