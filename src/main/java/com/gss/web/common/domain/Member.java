package com.gss.web.common.domain;

import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member{
	private static String userPrivilge = "USER";
	private String gssuserId;
	private int gssuserNum;
	private String email;
	private String userPassword;
	private String userPhone;
	private String privilge;
	private String userName;
	
	public Member(String gssuserid, String email, String userpassword, String userphone, String userName ) {
		this.gssuserId=gssuserid;
		this.email = email;
		this.userPassword = userpassword;
		this.userPhone = userphone;
		this.privilge = userPrivilge;
		this.userName=userName;
	}
}
