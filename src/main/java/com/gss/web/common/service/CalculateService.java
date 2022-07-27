package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.api.dto.PriceRatioDto;
import com.gss.web.api.dto.ResultTabDto;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateComplete;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.ItemInfo;
import com.gss.web.common.domain.PartyGetItem;
import com.gss.web.common.domain.UserRatioInfo;

public interface CalculateService {
	public List<CalculateMain> selectByUserNumber(int userNum);
	
	public int selectByUserId(String userId);

	public int selectCountMember(String partyName);
	
	public Calculate selectPartyLeader(String partyName);
	
	public List<Calculate> selectPartyMember(String partyName);
	
	public List<Calculate> selectBossNameAndGrade(String partyName);
	
	public List<PartyGetItem> selectItemNameAndPrice(String partyName);
	
	public int insertItemNameAndPrice(PartyGetItemDto pgiDto);
	
	public List<Calculate> selectMemberAll(String partyName);
	
	public int updateMemberOfPricePercent(PriceRatioDto priceRatioDto);
	
	public int updateResultState(String partyName);
	
	public int selectPartyNum(String partyName);
	
	public int selectMemberOfPartyNum (UserRatioInfo userRatioInfo);
	
	public List<Integer> selectPartyGetItemNumber (String partyName);
	
	public List<UserRatioInfo> selectUserRatioInfo (String partyName);
	
	public int insertResultTab (ResultTabDto resultTabDto);
	
	public List<CalculateComplete> selectCalculateCompletList (String userId);
	
	public List<PartyGetItem> selectCalculateCompleteItemList(String partyName);
	
	public List<Integer> selectBossNumByPartyName(String partyName);
	
	public List<ItemInfo> selectItemByItemNumber(int bossNum);
	
	public int selectItemNumByBossNumber (int bossNum);
}
