package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;

public interface BossService {
	public  List<BossDto> list();
	
	public  List<BossDto> selectAllBoss();
	
	public Integer insertBoss(Boss boss);
	
	public  int selectByBoss(Map map);
	
	public  BossDto deleteByBossName(String bossName);
	
	public String bossExistence(Boss boss);
}
