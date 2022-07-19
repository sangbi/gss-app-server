package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.ItemDto;

@Mapper
public interface ItemMapper {
	//보스 추가
	int insertItem(ItemDto ItemDto);
		
	public abstract List<ItemDto> list();
		
	//보스 리스트
	public abstract List<ItemDto> selectAllItem();
		
	//해당보스 정보
	public abstract ItemDto selectByItemName(String itemName);
		
	public int selectByItem(Map map);
		
	//해당보스 삭제
	public abstract ItemDto deleteByItemName(String itemName);
	
	//페이징
	public abstract List<ItemDto> selectSearchItem(ItemDto itemDto);
}
