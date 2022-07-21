package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;

public interface BossService {
	public  List<Boss> list();
	
	public  List<Boss> selectAllBoss();
	
	public Integer insertBoss(Boss boss);
	
	public  int selectByBoss(Map map);
	
	public  Boss deleteByBossName(String bossName);
	
	public String bossExistence(Boss boss);
}
