package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemOfBoss;

public interface ItemOfBossDAO {
	public int insertItemOfBoss(ItemOfBoss itemOfBoss);
	
	public List<Integer> selectAllItemOfBoss(Map map);
	
	public Item selectByBossItem(int itemNum);
}
