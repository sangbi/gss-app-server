package com.gss.web.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.dao.ItemDAO;
import com.gss.web.common.domain.Item;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{
	@Autowired
	private final ItemDAO itemDAO;
	
	@Autowired
	private ReloadableResourceBundleMessageSource res;
	
	@Override
	public List<Item> list() {
		return itemDAO.list();
	}
	
	@Override
	public Integer insertItem(Item item) {
		return itemDAO.insertItem(item);
	}
	
	@Override
	public Item deleteByItemName(String itemName) {
		return itemDAO.deleteByItemName(itemName);
	}
	@Override
	public List<Item> selectAllItem() {
		return itemDAO.selectAllItem();
	}

	@Override
	public int selectByItem(Map map) {
		return itemDAO.selectByItem(map);
	}
	
	@Override
	public String itemExistence(Item item) {
		String urlPath="";
		Integer itemExistenceNum;
		Map<String, String> map= new HashMap<String, String>();
		
		map.put("itemName", item.getItemName());
		map.put("classification", item.getClassification());
		itemExistenceNum=selectByItem(map);
		if(itemExistenceNum.equals(0)) {
			insertItem(item);
			urlPath="redirect:/admin/item";
		}else {
			urlPath="/admin/boss/insertItem";
		}
		
		return urlPath;
	}
	
	@Override
	public List<ItemDto> selectSearchItemName(String itemName){
		return itemDAO.selectSearchItemName(itemName);
	}

	public List<ItemDto> selectSearchClassification(String classification){
		return itemDAO.selectSearchClassification(classification);
	}
}
