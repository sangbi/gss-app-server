package com.gss.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.common.dao.CalculateDao;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.PartyGetItem;

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
	public String selectPartyLeader(String partyName) {
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
}
