package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.domain.Item;

@Mapper
public interface ItemMapper {
	int insertItem(Item item);

	public abstract List<ItemDto> list();

	public abstract List<ItemDto> selectAllItem();

	public abstract ItemDto selectByItemName(String itemName);

	public int selectByItem(Map map);

	public abstract ItemDto deleteByItemName(String itemName);

	public List<ItemDto> selectSearchItemName(String itemName);

	public List<ItemDto> selectSearchClassification(String classification);
}
