package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberOfPartyTab {
	private int partyNum;
	private int gssUserNum;
	private String charaterName;
	private boolean partyLeader;
}
