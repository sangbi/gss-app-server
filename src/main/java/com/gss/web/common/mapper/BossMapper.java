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
	
	public abstract Boss selectByBossName(String bossName);
	
	public int selectByBoss(Map map);
	
	public abstract Boss deleteByBossName(String bossName);
}
