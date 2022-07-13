package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberCreateDto {
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class MemberCreateRequest {
		private String email;
		private String password;
		private String phoneNumber;
		private String privilge;
	}
}
