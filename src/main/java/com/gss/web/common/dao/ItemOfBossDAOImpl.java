package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.common.domain.Boss;
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
	
	@Override
	public Boss selectByBoss(int bossNum) {
		return sqlSession.getMapper(ItemOfBossMapper.class).selectByBoss(bossNum);
	}
	
	@Override
	public List<Integer> selectInsertItemList(Map map) {
		return sqlSession.getMapper(ItemOfBossMapper.class).selectInsertItemList(map);
	}
	
	@Override
	public List<Item> selectItemListByItemNum(int itemNum) {
		return sqlSession.getMapper(ItemOfBossMapper.class).selectItemListByItemNum(itemNum);
	}
	
	@Override
	public int deleteItemListByItemNum (ItemOfBoss itemOfBoss) {
		return sqlSession.getMapper(ItemOfBossMapper.class).deleteItemListByItemNum(itemOfBoss);
	}
}
