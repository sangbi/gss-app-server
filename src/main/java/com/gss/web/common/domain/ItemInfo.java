package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemInfo {
	private String itemName;
	private String itemImagePath;
	private String classification;
}
