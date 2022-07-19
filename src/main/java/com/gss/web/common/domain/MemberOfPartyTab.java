package com.gss.web.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberOfPartyTab {
	private int memberofpartynum;
	private int partynum;
	private String charatername;
	private boolean partyleader;
	
	public MemberOfPartyTab(int memberofpartynum, int partynum, String charatername, boolean partyleader) {
		super();
		this.memberofpartynum = memberofpartynum;
		this.partynum = partynum;
		this.charatername = charatername;
		this.partyleader = partyleader;
	}
}
