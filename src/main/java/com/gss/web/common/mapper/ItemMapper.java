package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.domain.Item;

@Mapper
public interface ItemMapper {
	int insertItem(Item item);

	public abstract List<Item> list();

	public abstract List<Item> selectAllItem();

	public abstract Item selectByItemName(String itemName);

	public int selectByItem(Map map);

	public abstract Item deleteByItemName(String itemName);

	public List<ItemDto> selectSearchItemName(String itemName);

	public List<ItemDto> selectSearchClassification(String classification);
}
