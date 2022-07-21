package com.gss.web.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.dao.BossDAO;
import com.gss.web.common.domain.Boss;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BossServiceImpl implements BossService{
	@Autowired
	private final BossDAO bossDAO;
	
	@Autowired
	private ReloadableResourceBundleMessageSource res;
	
	@Override
	public List<Boss> list() {
		return bossDAO.list();
	}
	
	@Override
	public Integer insertBoss(Boss boss) {
		return bossDAO.insertBoss(boss);
	}
	
	@Override
	public Boss deleteByBossName(String bossName) {
		return bossDAO.deleteByBossName(bossName);
	}
	@Override
	public List<Boss> selectAllBoss() {
		return bossDAO.selectAllBoss();
	}

	@Override
	public int selectByBoss(Map map) {
		return bossDAO.selectByBoss(map);
	}
	
	@Override
	public String bossExistence(Boss boss) {
		String urlPath="";
		Integer bossExistenceNum;
		Map<String, String> map= new HashMap<String, String>();
		
		map.put("bossName", boss.getBossName());
		map.put("bossGrade", boss.getBossGrade());
		bossExistenceNum=selectByBoss(map);
		if(bossExistenceNum.equals(0)) {
			insertBoss(boss);
			urlPath="redirect:/admin/boss";
		}else {
			urlPath="/admin/boss/insertBoss";
		}
		
		return urlPath;
	}
}
