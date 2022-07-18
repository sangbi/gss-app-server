package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.gss.web.api.dto.ItemDto;

public class ItemDAOImpl implements ItemDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ItemDto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertItem(ItemDto itemDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ItemDto> selectAllItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDto selectByItemName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDto deleteByItemName(String bossName) {
		// TODO Auto-generated method stub
		return null;
	}
}
