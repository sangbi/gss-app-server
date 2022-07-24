package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Boss {
	private long bossNum;	
	private String bossName;	
	private String bossImagepath;	
	private String bossGrade;	
	
	public Boss(String boossName,String bossImagepath,String bossGrade) {
		this.bossName=boossName;
		this.bossImagepath=bossImagepath;
		this.bossGrade=bossGrade;
	}
	
}
