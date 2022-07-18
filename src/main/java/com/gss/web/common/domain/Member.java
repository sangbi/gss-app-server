package com.gss.web.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	private static int userPrivilge = 0;
	private String gssuserid;
	private int gssusernum;
	private String email;
	private String userpassword;
	private String userphone;
	private int privilge;

	public Member(String gssuserid, String email, String userpassword, String userphone) {
		this.gssuserid=gssuserid;
		this.email = email;
		this.userpassword = userpassword;
		this.userphone = userphone;
		this.privilge = userPrivilge;
	}
}
