package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import com.gss.web.common.domain.Item;

public interface ItemDAO {

	public  Integer insertItem(Item item);
		
	public  List<Item> list();
		
	public  List<Item> selectAllItem();
		
	public  int selectByItem(Map map);
		
	public  int deleteByItemName(Map map);
		
	public List<Item> selectSearchItemName(String itemName);
	
	public List<Item> selectSearchClassification(String classification);
	
	public Item selectByItemNameAndClassification(Map map);
	
	public List<Item> selectAllItemPaging(Integer page);
	
	public int selectItemCount();
	
	public List<Item> selectSearchItemNamePaging(Item item);
	
	public List<Item> selectSearchClassificationPaging(Item item);
}
