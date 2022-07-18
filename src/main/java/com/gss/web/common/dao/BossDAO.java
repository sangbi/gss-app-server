package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import com.gss.web.api.dto.BossDto;

public interface BossDAO {
	//보스 추가
	public  int insertBoss(BossDto bossDto);
	
	public  List<BossDto> list();
	
	//보스 리스트
	public  List<BossDto> selectAllBoss();
	
	//해당보스 정보
	public  int selectByBoss(Map map);
	
	//해당보스 삭제
	public  BossDto deleteByBossName(String bossName);
}
