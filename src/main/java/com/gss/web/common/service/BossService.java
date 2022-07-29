package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import com.gss.web.common.domain.Boss;

public interface BossService {
	public  List<Boss> list();
	
	public  List<Boss> selectAllBoss();
	
	public Integer insertBoss(Boss boss);
	
	public  int selectByBoss(Map map);
	
	public  int deleteByBossName(Map map);
	
	public String bossExistence(Boss boss);

	public Boss selectByBossNameAndGrade(Map map);
	
	public List<Boss> selectAllBossPaging(Integer page);
	
	public int selectBossCount();
}
