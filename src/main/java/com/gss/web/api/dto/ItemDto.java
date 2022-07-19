package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private String itemName;	//아이템 이름
	private String classification;	//아이템 분류
	private String itemImagepath;	//아이템 이미지
	
	//검색기능
	private String classificationType; //분류 타입
	private String keyword;	//검색 내용
	
	//페이지
	private int start;
	private int end;
	private String name;
}
