package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.api.dto.CalculateMainDto;
import com.gss.web.common.mapper.CalculateMapper;

@Repository
public class CalculateDaoImpl implements CalculateDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CalculateMainDto> selectByUserNumber(int userNum) {
		return sqlSession.getMapper(CalculateMapper.class).selectByUserNumber(userNum);
	}
	
	@Override
	public int selectByUserId(String userId) {
		return sqlSession.getMapper(CalculateMapper.class).selectByUserId(userId);
	}
}
