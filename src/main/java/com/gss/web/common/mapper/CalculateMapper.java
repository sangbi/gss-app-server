package com.gss.web.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;

@Mapper
public interface CalculateMapper {
	public List<CalculateMain> selectByUserNumber(int userNum);
	
	public int selectByUserId(String userId);
	
	public int selectCountMember(String partyName);
	
	public String selectPartyLeader(String partyName);
	
	public List<Calculate> selectPartyMember(String partyName);
	
	public List<Calculate> selectBossNameAndGrade(String partyName);
}
