package com.gss.web.api.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
	@NotBlank(message="{Blank.userid}")
	private String userid;
	@NotBlank(message="{Blank.password}")
	private String password;
	private boolean rememberUserid;
}
