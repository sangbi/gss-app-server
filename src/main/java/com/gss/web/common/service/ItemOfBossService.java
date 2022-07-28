package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import com.gss.web.common.domain.Boss;
import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemOfBoss;

public interface ItemOfBossService {
	public int insertItemOfBoss(ItemOfBoss itemOfBoss);
	
	public List<Integer> selectAllItemOfBoss(Map map);
	
	public Item selectByBossItem(int itemNum);
	
	public Boss selectByBoss(int bossNum);
	
	public List<Integer> selectInsertItemList(Map map);
	
	public List<Item> selectItemListByItemNum (int itemNum); 
	
	public int deleteItemListByItemNum (ItemOfBoss itemOfBoss);
}
