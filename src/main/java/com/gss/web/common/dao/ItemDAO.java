package com.gss.web.common.dao;

import java.util.List;

import com.gss.web.api.dto.ItemDto;

public interface ItemDAO {
	public abstract List<ItemDto> list();
	
	//아이템 추가
	public abstract int insertItem(ItemDto itemDto);
	
	//아이템 리스트
	public abstract List<ItemDto> selectAllItem();
	
	//해당 아이템 정보
	public abstract ItemDto selectByItemName(String itemName);
	
	//해당 아이템 삭제
	public abstract ItemDto deleteByItemName(String itemName);
	
	//검색
	public abstract List<ItemDto> selectSearchItem(ItemDto itemDto);
}
