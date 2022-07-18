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
	private String partyname;
	private String bossname;
	private String level;
	private String email;
	private String character;
}
