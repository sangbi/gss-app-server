package com.gss.web.common.dao;

import java.util.List;

import com.gss.web.api.dto.CalculateMainDto;

public interface CalculateDao {
	public List<CalculateMainDto> selectByUserNumber(int userNum);
	
	public int selectByUserId (String userId);
}
