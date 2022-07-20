package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.CalculateMainDto;

public interface CalculateService {
	public List<CalculateMainDto> selectByUserNumber(int userNum);
	
	public int selectByUserId(String userId);
}
