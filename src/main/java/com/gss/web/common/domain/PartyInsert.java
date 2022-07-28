package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartyInsert {
	private int gssUserNum;
	private int partyNum;
	private String charaterName;
	private boolean partyLeader;
}
