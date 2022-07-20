package com.gss.web.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.CalculateMainDto;

@Mapper
public interface CalculateMapper {
	public List<CalculateMainDto> selectByUserNumber(int userNum);
	
	public int selectByUserId(String userId);
}
