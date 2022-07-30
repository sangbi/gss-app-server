package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartySearchDto {
	private String gssUserId;
	private String email;
	
	private String keyWord;
	
	
}
