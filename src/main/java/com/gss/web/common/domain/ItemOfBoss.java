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
	private String itemName;
	
	public ItemOfBoss(String bossName,String bossGrade) {
		this.bossName=bossName;
		this.bossGrade=bossGrade;
	}

	public ItemOfBoss(int itemNum, String bossName, String bossGrade) {
		this.itemNum = itemNum;
		this.bossName = bossName;
		this.bossGrade = bossGrade;
	}
	
	public ItemOfBoss(int bossNum, int itemNum) {
		this.bossNum = bossNum;
		this.itemNum = itemNum;
	}
	
	public ItemOfBoss(String itemName, String bossName, String bossGrade) {
		this.itemName = itemName;
		this.bossName = bossName;
		this.bossGrade = bossGrade;
	}
}
