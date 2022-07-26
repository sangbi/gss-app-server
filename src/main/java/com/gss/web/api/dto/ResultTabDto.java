package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultTabDto {
	private int gssUserNum;
	private int memberOfPartyNum;
	private int pgiKey;
	private int partyMemberCount;
	private long resultPrice;
}
