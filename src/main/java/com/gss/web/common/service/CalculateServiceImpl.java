package com.gss.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.CalculateMainDto;
import com.gss.web.common.dao.CalculateDao;

@Service
public class CalculateServiceImpl implements CalculateService {
	@Autowired
	private CalculateDao calculateMainDao;
	
	@Override
	public List<CalculateMainDto> selectByUserNumber(int userNum) {
		return calculateMainDao.selectByUserNumber(userNum);
	}
	
	@Override
	public int selectByUserId(String userId) {
		return calculateMainDao.selectByUserId(userId);
	}
}
