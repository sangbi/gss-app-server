package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;

@Mapper
public interface BossMapper {
	int insertBoss(Boss boss);
	
	public abstract List<BossDto> list();
	
	public abstract List<BossDto> selectAllBoss();
	
	public abstract BossDto selectByBossName(String bossName);
	
	public int selectByBoss(Map map);
	
	public abstract BossDto deleteByBossName(String bossName);
}
