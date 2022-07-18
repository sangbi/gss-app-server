package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.ItemDto;

public interface ItemService {
	//아이템정보 리스트
	public abstract List<ItemDto> list();
	
	//아이템 추가
	public abstract void insertItem(ItemDto itemDto);
	
	//아이템 개인정보
	public abstract ItemDto selectByItemName(String itemName);
	
	//아이템 삭제
	public abstract ItemDto deleteByItemName(String itemName);
}
