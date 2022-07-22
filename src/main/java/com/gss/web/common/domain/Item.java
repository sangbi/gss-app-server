package com.gss.web.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
	private long itemNum;	
	private String itemName;	
	private String classification;	
	private String itemImagepath;	
	
	private String type;
	private String keyword;
	
	public Item(String itemName,String itemImagepath,String classification) {
		this.itemName=itemName;
		this.itemImagepath=itemImagepath;
		this.classification=classification;
	}
}
