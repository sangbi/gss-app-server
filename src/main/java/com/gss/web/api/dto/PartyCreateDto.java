package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PartyCreateDto {
	private String partyName;
	private String bossName;
	private String level;
	private String id;
	private String charaterName;
}
