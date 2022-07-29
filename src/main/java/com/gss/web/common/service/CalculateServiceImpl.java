package com.gss.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.api.dto.PriceRatioDto;
import com.gss.web.api.dto.ResultTabDto;
import com.gss.web.common.dao.CalculateDao;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateComplete;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.ItemInfo;
import com.gss.web.common.domain.PartyGetItem;
import com.gss.web.common.domain.UserRatioInfo;

@Service
public class CalculateServiceImpl implements CalculateService {
	@Autowired
	private CalculateDao calculateDao;
	
	@Override
	public List<CalculateMain> selectByUserNumber(int userNum) {
		return calculateDao.selectByUserNumber(userNum);
	}
	
	@Override
	public int selectByUserId(String userId) {
		return calculateDao.selectByUserId(userId);
	}
	
	@Override
	public int selectCountMember(String partyName) {
		return calculateDao.selectCountMember(partyName);
	}
	
	@Override
	public Calculate selectPartyLeader(String partyName) {
		return calculateDao.selectPartyLeader(partyName);
	}
	
	@Override
	public List<Calculate> selectPartyMember(String partyName) {
		return calculateDao.selectPartyMember(partyName);
	}
	
	@Override
	public List<Calculate> selectBossNameAndGrade(String partyName) {
		return calculateDao.selectBossNameAndGrade(partyName);
	}
	
	@Override
	public List<PartyGetItem> selectItemNameAndPrice(String partyName) {
		return calculateDao.selectItemNameAndPrice(partyName);
	}
	
	@Override
	public int insertItemNameAndPrice(PartyGetItemDto pgiDto) {
		return calculateDao.insertItemNameAndPrice(pgiDto);
	}
	
	@Override
	public List<Calculate> selectMemberAll(String partyName) {
		return calculateDao.selectMemberAll(partyName);
	}
	
	@Override
	public int updateMemberOfPricePercent(PriceRatioDto priceRatioDto) {
		return calculateDao.updateMemberOfPricePercent(priceRatioDto);
	}
	
	@Override
	public int updateResultState(String partyName) {
		return calculateDao.updateResultState(partyName);
	}
	
	@Override
	public int selectPartyNum(String partyName) {
		return calculateDao.selectPartyNum(partyName);
	}
	
	@Override
	public int selectMemberOfPartyNum(UserRatioInfo userRatioInfo) {
		return calculateDao.selectMemberOfPartyNum(userRatioInfo);
	}
	
	@Override
	public List<Integer> selectPartyGetItemNumber(String partyName) {
		return calculateDao.selectPartyGetItemNumber(partyName);
	}
	
	@Override
	public List<UserRatioInfo> selectUserRatioInfo(String partyName) {
		return calculateDao.selectUserRatioInfo(partyName);
	}
	
	@Override
	public int insertResultTab(ResultTabDto resultTabDto) {
		return calculateDao.insertResultTab(resultTabDto);
	}
	
	@Override
	public List<CalculateComplete> selectCalculateCompletList(String userId) {
		return calculateDao.selectCalculateCompletList(userId);
	}
	
	@Override
	public List<PartyGetItem> selectCalculateCompleteItemList(String partyName) {
		return calculateDao.selectCalculateCompleteItemList(partyName);
	}
	
	@Override
	public List<Integer> selectBossNumByPartyName(String partyName) {
		return calculateDao.selectBossNumByPartyName(partyName);
	}
	
	@Override
	public List<ItemInfo> selectItemByItemNumber(int bossNum) {
		return calculateDao.selectItemByItemNumber(bossNum);
	}
	
	@Override
	public int selectItemNumByBossNumber(int bossNum) {
		return calculateDao.selectItemNumByBossNumber(bossNum);
	}
	
	@Override
	public int deletePartyGetItem(int pgiKey) {
		return calculateDao.deletePartyGetItem(pgiKey);
	}
}
