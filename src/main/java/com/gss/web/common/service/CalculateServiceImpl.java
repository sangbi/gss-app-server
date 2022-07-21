package com.gss.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.common.dao.CalculateDao;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;

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
}
