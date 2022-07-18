package com.gss.web.api.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BossDto {
	private String bossName;	//보스 이름
	private MultipartFile bossImagepath;	//보스 이미지
	private String bossGrade;	//보스 난이도	
}
