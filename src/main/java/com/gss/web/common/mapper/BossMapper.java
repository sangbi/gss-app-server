package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Boss;

@Mapper
public interface BossMapper {
	int insertBoss(Boss boss);
	
	public abstract List<Boss> list();
	
	public abstract List<Boss> selectAllBoss();
	
	public int selectByBoss(Map map);
	
	public int deleteByBossName(Map map);
	
	public abstract Boss selectByBossNameAndGrade(Map map);
	
	public List<Boss> selectAllBossPaging(Integer page);
	
	public int selectBossCount();
}
