package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemOfBoss {
	private int itemOfBossNum;
	private int itemNum;
	private int bossNum;
	
	private String bossName;
	private String bossGrade;
	
	public ItemOfBoss(String bossName,String bossGrade) {
		this.bossName=bossName;
		this.bossGrade=bossGrade;
	}
}
