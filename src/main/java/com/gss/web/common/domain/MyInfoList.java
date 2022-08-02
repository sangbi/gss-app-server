package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class MyInfoList {
	private String partyName;
	private String charaterName;
	private int gssUserNum;
	
	public MyInfoList(String partyName, String charaterName) {
		this.partyName=partyName;
		this.charaterName=charaterName;
	}
}
