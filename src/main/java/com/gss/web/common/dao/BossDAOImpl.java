package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;
import com.gss.web.common.mapper.BossMapper;

@Repository
public class BossDAOImpl implements BossDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Boss> list() {
		return sqlSession.getMapper(BossMapper.class).list();
	}

	@Override
	public Integer insertBoss(Boss boss) {
		return sqlSession.getMapper(BossMapper.class).insertBoss(boss);
	}

	@Override
	public List<Boss> selectAllBoss() {
		return sqlSession.getMapper(BossMapper.class).selectAllBoss();
	}

	@Override
	public int deleteByBossName(Map map) {
		return sqlSession.getMapper(BossMapper.class).deleteByBossName(map);
	}

	@Override
	public int selectByBoss(Map map) {
		return sqlSession.getMapper(BossMapper.class).selectByBoss(map);
	}
	
	@Override
	public  Boss selectByBossNameAndGrade(Map map) {
		return sqlSession.getMapper(BossMapper.class).selectByBossNameAndGrade(map);
	}
	
	@Override
	public List<Boss> selectAllBossPaging(Integer page) {
		return sqlSession.getMapper(BossMapper.class).selectAllBossPaging(page);
	}
	
	@Override
	public int selectBossCount() {
		return sqlSession.getMapper(BossMapper.class).selectBossCount();
	}
}
