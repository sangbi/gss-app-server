package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.gss.web.api.dto.ItemDto;
import com.gss.web.common.mapper.ItemMapper;

public class ItemDAOImpl implements ItemDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ItemDto> list() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ItemMapper.class).list();
	}

	@Override
	public int insertItem(ItemDto itemDto) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ItemMapper.class).insertItem(itemDto);
	}

	@Override
	public List<ItemDto> selectAllItem() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ItemMapper.class).list();
	}

	@Override
	public ItemDto selectByItemName(String itemName) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ItemMapper.class).selectByItemName(itemName);
	}

	@Override
	public ItemDto deleteByItemName(String itemName) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ItemMapper.class).deleteByItemName(itemName);
	}
	
	//검색
	@Override
	public List<ItemDto> selectSearchItem(ItemDto itemDto) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ItemMapper.class).selectSearchItem(itemDto);
	}
}
