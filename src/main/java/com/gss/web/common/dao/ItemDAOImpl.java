	package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.common.domain.Item;
import com.gss.web.common.mapper.ItemMapper;

@Repository
public class ItemDAOImpl implements ItemDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Item> list() {
		return sqlSession.getMapper(ItemMapper.class).list();
	}

	@Override
	public Integer insertItem(Item item) {
		return sqlSession.getMapper(ItemMapper.class).insertItem(item);
	}

	@Override
	public List<Item> selectAllItem() {
		return sqlSession.getMapper(ItemMapper.class).selectAllItem();
	}

	@Override
	public int deleteByItemName(Map map) {
		return sqlSession.getMapper(ItemMapper.class).deleteByItemName(map);
	}

	@Override
	public int selectByItem(Map map) {
		return sqlSession.getMapper(ItemMapper.class).selectByItem(map);
	}

	@Override
	public List<Item> selectSearchItemName(String itemName) {
		return sqlSession.getMapper(ItemMapper.class).selectSearchItemName(itemName);
	}

	@Override
	public List<Item> selectSearchClassification(String classification) {
		return sqlSession.getMapper(ItemMapper.class).selectSearchClassification(classification);
	}
	
	@Override
	public Item selectByItemNameAndClassification(Map map) {
		return sqlSession.getMapper(ItemMapper.class).selectByItemNameAndClassification(map);
	}
	
	@Override
	public List<Item> selectAllItemPaging(Integer page) {
		return sqlSession.getMapper(ItemMapper.class).selectAllItemPaging(page);
	}
	
	@Override
	public int selectItemCount() {
		return sqlSession.getMapper(ItemMapper.class).selectItemCount();
	}
	
	@Override
	public List<Item> selectSearchItemNamePaging(Item item) {
		return sqlSession.getMapper(ItemMapper.class).selectSearchItemNamePaging(item);
	}
	
	@Override
	public List<Item> selectSearchClassificationPaging(Item item) {
		return sqlSession.getMapper(ItemMapper.class).selectSearchClassificationPaging(item);
	}
}
