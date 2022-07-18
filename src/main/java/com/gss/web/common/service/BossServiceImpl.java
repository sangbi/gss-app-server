package com.gss.web.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//보스정보 리스트
	@Override
	public List<BossDto> list() {
		// TODO Auto-generated method stub
		return bossDAO.list();
	}
	
	//보스 추가
	@Override
	public Integer insertBoss(Boss boss) {
		return bossDAO.insertBoss(boss);
	}
	
	//해당 보스 삭제
	@Override
	public BossDto deleteByBossName(String bossName) {
		// TODO Auto-generated method stub
		return bossDAO.deleteByBossName(bossName);
	}
	@Override
	public List<BossDto> selectAllBoss() {
		return null;
	}

	@Override
	public int selectByBoss(Map map) {
		return bossDAO.selectByBoss(map);
	}
	
	public String bossExistence(Boss boss) {
		String urlPath="";
		Integer bossExistenceNum;
		Map<String, String> map= new HashMap<String, String>();
		map.put("bossName", boss.getBossName());
		map.put("bossGrade", boss.getBossGrade());
		bossExistenceNum=selectByBoss(map);
		if(bossExistenceNum.equals(0)) {
			insertBoss(boss);
			urlPath="/admin/boss/bossList";
		}else {
			urlPath="/admin/boss/insertBoss";
		}
		return urlPath;
	}
}
