package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.PartyGetItem;
import com.gss.web.common.mapper.CalculateMapper;

@Repository
public class CalculateDaoImpl implements CalculateDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CalculateMain> selectByUserNumber(int userNum) {
		return sqlSession.getMapper(CalculateMapper.class).selectByUserNumber(userNum);
	}
	
	@Override
	public int selectByUserId(String userId) {
		return sqlSession.getMapper(CalculateMapper.class).selectByUserId(userId);
	}
	
	@Override
	public int selectCountMember(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectCountMember(partyName);
	}
	
	@Override
	public String selectPartyLeader(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectPartyLeader(partyName);
	}
	
	@Override
	public List<Calculate> selectPartyMember(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectPartyMember(partyName);
	}
	
	@Override
	public List<Calculate> selectBossNameAndGrade(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectBossNameAndGrade(partyName);
	}
	
	@Override
	public List<PartyGetItem> selectItemNameAndPrice(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectItemNameAndPrice(partyName);
	}
	
	@Override
	public int insertItemNameAndPrice(PartyGetItemDto pgiDto) {
		return sqlSession.getMapper(CalculateMapper.class).insertItemNameAndPrice(pgiDto);
	}
}
