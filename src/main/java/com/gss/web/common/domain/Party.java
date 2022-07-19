package com.gss.web.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Party {
	private int partynum;
	private String partyname;
	
	public Party(int partynum, String partyname) {
		super();
		this.partynum = partynum;
		this.partyname = partyname;
	}
}
