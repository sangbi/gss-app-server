package com.gss.web.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberCreateDto {
	@NotBlank
	private String name; 
	@Pattern(regexp = "^[a-zA-Z0-9]{2,9}$", message="{Pattern.userid}")
	private String userid;
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message="{Pattern.email}")
	private String email;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "{Pattern.password}")
	private String password;
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "{Pattern.password}")
	private String confirmPassword;
	@Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",message="{Pattern.phone}")
	private String phoneNumber;
	@NotBlank
	private String certificationFlag;
	
	public MemberCreateDto(String name, String userid, String email, String password, String phoneNumber) {
		this.name=name;
		this.userid=userid;
		this.email=email;
		this.password=password;
		this.phoneNumber=phoneNumber;
	}
}