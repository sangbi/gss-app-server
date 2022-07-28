package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Boss;
import com.gss.web.common.domain.Item;
import com.gss.web.common.domain.ItemOfBoss;

@Mapper
public interface ItemOfBossMapper {
	int insertItemOfBoss(ItemOfBoss itemOfBoss);
	
	public List<Integer> selectAllItemOfBoss(Map map);
	
	public Item selectByBossItem(int itemNum);
	
	public Boss selectByBoss(int bossNum);
	
	public List<Integer> selectInsertItemList(Map map);
	
	public List<Item> selectItemListByItemNum (int itemNum); 
	
	public int deleteItemListByItemNum (ItemOfBoss itemOfBoss);
}
