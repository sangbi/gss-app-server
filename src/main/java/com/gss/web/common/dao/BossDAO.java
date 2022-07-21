package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.domain.Boss;

public interface BossDAO {

	public  Integer insertBoss(Boss boss);
	
	public  List<Boss> list();
	
	public  List<Boss> selectAllBoss();
	
	public  int selectByBoss(Map map);
	
	public  Boss deleteByBossName(String bossName);
}
