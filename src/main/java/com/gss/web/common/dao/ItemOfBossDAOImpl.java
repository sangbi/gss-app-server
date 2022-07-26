package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemOfBoss;
import com.gss.web.common.mapper.ItemOfBossMapper;

@Repository
public class ItemOfBossDAOImpl implements ItemOfBossDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertItemOfBoss(ItemOfBoss itemOfBoss) {
		return sqlSession.getMapper(ItemOfBossMapper.class).insertItemOfBoss(itemOfBoss);
	}
	
	@Override
	public List<Integer> selectAllItemOfBoss(Map map){
		return sqlSession.getMapper(ItemOfBossMapper.class).selectAllItemOfBoss(map);
	}
	
	@Override
	public Item selectByBossItem(int itemNum){
		return sqlSession.getMapper(ItemOfBossMapper.class).selectByBossItem(itemNum);
	}
}
