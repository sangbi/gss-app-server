package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Boss {
	private long bossNum;	//보스 고유번호
	private String bossName;	//보스 이름
	private String bossImagepath;	//보스 이미지
	private String bossGrade;	//보스 난이도
	
	public Boss(String boossName,String bossImagepath,String bossGrade) {
		this.bossName=boossName;
		this.bossImagepath=bossImagepath;
		this.bossGrade=bossGrade;
	}
}
