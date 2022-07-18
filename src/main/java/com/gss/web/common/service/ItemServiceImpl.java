package com.gss.web.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.dao.ItemDAO;

public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAO itemDAO;
	
	//아이템 리스트
	@Override
	public List<ItemDto> list() {
		// TODO Auto-generated method stub
		return itemDAO.list();
	}
	
	//아이템 추가
	@Override
	public void insertItem(ItemDto itemDto) {
		// TODO Auto-generated method stub
	}

	//해당 아이템 정보
	@Override
	public ItemDto selectByItemName(String itemName) {
		// TODO Auto-generated method stub
		return itemDAO.selectByItemName(itemName);
	}

	//해당 아이템 삭제
	@Override
	public ItemDto deleteByItemName(String itemName) {
		// TODO Auto-generated method stub
		return itemDAO.deleteByItemName(itemName);
	}
}
