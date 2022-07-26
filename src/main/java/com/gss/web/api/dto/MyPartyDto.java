package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyPartyDto {
	private String partyName;
	private String bossName;
	private String bossGrade;
	private String gssUserId;
	private String charaterName;
}
