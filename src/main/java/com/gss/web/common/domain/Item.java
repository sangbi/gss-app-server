package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
	private long itemNum;	//아이템 고유번호
	private String itemName;	//아이템 이름
	private String itemType;	//아이템 분류
	private String itemImage;	//아이템 이미지
}
