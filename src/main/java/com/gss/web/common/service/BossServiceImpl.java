package com.gss.web.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.BossDto;
import com.gss.web.common.dao.BossDAO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BossServiceImpl implements BossService{
	@Autowired
	private BossDAO bossDAO;
	
	//보스정보 리스트
	@Override
	public List<BossDto> list() {
		// TODO Auto-generated method stub
		return bossDAO.list();
	}
	
	//보스 추가
	@Override
	public int insertBoss(BossDto bossDto) {
		// TODO Auto-generated method stub
		return bossDAO.insertBoss(bossDto);
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
}
