package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;

public interface BossService {
	//보스정보 리스트
	public  List<BossDto> list();
	
	//보스 리스트
	public  List<BossDto> selectAllBoss();
	
	//보스 추가
	public Integer insertBoss(Boss boss);
	
	//보스 존재 여부
	public  int selectByBoss(Map map);
	
	//보스 삭제
	public  BossDto deleteByBossName(String bossName);
}