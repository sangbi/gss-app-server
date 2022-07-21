package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.domain.Item;

public interface ItemDAO {

	public  Integer insertItem(Item item);
		
	public  List<ItemDto> list();
		
	public  List<ItemDto> selectAllItem();
		
	public  int selectByItem(Map map);
		
	public  ItemDto deleteByItemName(String itemName);
		
	public List<ItemDto> selectSearchItemName(String itemName);
	
	public List<ItemDto> selectSearchClassification(String classification);
}
