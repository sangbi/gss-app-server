package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;

@Mapper
public interface BossMapper {
	//보스 추가
	int insertBoss(Boss boss);
	
	public abstract List<BossDto> list();
	
	//보스 리스트
	public abstract List<BossDto> selectAllBoss();
	
	//해당보스 정보
	public abstract BossDto selectByBossName(String bossName);
	
	public int selectByBoss(Map map);
	
	//해당보스 삭제
	public abstract BossDto deleteByBossName(String bossName);
}
