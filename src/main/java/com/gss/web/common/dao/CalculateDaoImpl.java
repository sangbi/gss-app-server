package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.api.dto.PartyGetItemDto;
import com.gss.web.api.dto.PriceRatioDto;
import com.gss.web.api.dto.ResultTabDto;
import com.gss.web.common.domain.Calculate;
import com.gss.web.common.domain.CalculateComplete;
import com.gss.web.common.domain.CalculateMain;
import com.gss.web.common.domain.ItemInfo;
import com.gss.web.common.domain.PartyGetItem;
import com.gss.web.common.domain.UserRatioInfo;
import com.gss.web.common.mapper.CalculateMapper;

@Repository
public class CalculateDaoImpl implements CalculateDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CalculateMain> selectByUserNumber(int userNum) {
		return sqlSession.getMapper(CalculateMapper.class).selectByUserNumber(userNum);
	}
	
	@Override
	public int selectByUserId(String userId) {
		return sqlSession.getMapper(CalculateMapper.class).selectByUserId(userId);
	}
	
	@Override
	public int selectCountMember(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectCountMember(partyName);
	}
	
	@Override
	public Calculate selectPartyLeader(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectPartyLeader(partyName);
	}
	
	@Override
	public List<Calculate> selectPartyMember(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectPartyMember(partyName);
	}
	
	@Override
	public List<Calculate> selectBossNameAndGrade(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectBossNameAndGrade(partyName);
	}
	
	@Override
	public List<PartyGetItem> selectItemNameAndPrice(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectItemNameAndPrice(partyName);
	}
	
	@Override
	public int insertItemNameAndPrice(PartyGetItemDto pgiDto) {
		return sqlSession.getMapper(CalculateMapper.class).insertItemNameAndPrice(pgiDto);
	}
	
	@Override
	public List<Calculate> selectMemberAll(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectMemberAll(partyName);
	}
	
	@Override
	public int updateMemberOfPricePercent(PriceRatioDto priceRatioDto) {
		return sqlSession.getMapper(CalculateMapper.class).updateMemberOfPricePercent(priceRatioDto);
	}
	
	@Override
	public int updateResultState(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).updateResultState(partyName);
	}
	
	@Override
	public int selectPartyNum(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectPartyNum(partyName);
	}
	
	@Override
	public int selectMemberOfPartyNum(UserRatioInfo userRatioInfo) {
		return sqlSession.getMapper(CalculateMapper.class).selectMemberOfPartyNum(userRatioInfo);
	}
	
	@Override
	public List<Integer> selectPartyGetItemNumber(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectPartyGetItemNumber(partyName);
	}
	
	@Override
	public List<UserRatioInfo> selectUserRatioInfo(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectUserRatioInfo(partyName);
	}
	
	@Override
	public int insertResultTab(ResultTabDto resultTabDto) {
		return sqlSession.getMapper(CalculateMapper.class).insertResultTab(resultTabDto);
	}
	
	@Override
	public List<CalculateComplete> selectCalculateCompletList(String userId) {
		return sqlSession.getMapper(CalculateMapper.class).selectCalculateCompletList(userId);
	}
	
	@Override
	public List<PartyGetItem> selectCalculateCompleteItemList(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectCalculateCompleteItemList(partyName);
	}
	
	@Override
	public List<Integer> selectBossNumByPartyName(String partyName) {
		return sqlSession.getMapper(CalculateMapper.class).selectBossNumByPartyName(partyName);
	}
	
	@Override
	public List<ItemInfo> selectItemByItemNumber(int bossNum) {
		return sqlSession.getMapper(CalculateMapper.class).selectItemByItemNumber(bossNum);
	}
	
	@Override
	public int selectItemNumByBossNumber(int bossNum) {
		return sqlSession.getMapper(CalculateMapper.class).selectItemNumByBossNumber(bossNum);
	}
	
	@Override
	public int deletePartyGetItem(int pgiKey) {
		return sqlSession.getMapper(CalculateMapper.class).deletePartyGetItem(pgiKey);
	}
}
