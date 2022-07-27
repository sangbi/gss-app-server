package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.common.dao.ItemOfBossDAO;
import com.gss.web.common.domain.Boss;
import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemOfBoss;

@Service
public class ItemOfBossServiceImpl implements ItemOfBossService{
	@Autowired
	private ItemOfBossDAO itemOfBossDAO;
	
	@Override
	public int insertItemOfBoss(ItemOfBoss itemOfBoss) {
		return itemOfBossDAO.insertItemOfBoss(itemOfBoss);
	}
	
	@Override
	public List<Integer> selectAllItemOfBoss(Map map){
		return itemOfBossDAO.selectAllItemOfBoss(map);
	}
	
	@Override
	public Item selectByBossItem(int itemNum){
		return itemOfBossDAO.selectByBossItem(itemNum);
	}
	
	@Override
	public Boss selectByBoss(int bossNum) {
		return itemOfBossDAO.selectByBoss(bossNum);
	}
	
	@Override
	public Item selectInsertItemList(ItemOfBoss itemOfBoss) {
		return itemOfBossDAO.selectInsertItemList(itemOfBoss);
	}
}
