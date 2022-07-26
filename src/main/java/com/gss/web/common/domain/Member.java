package com.gss.web.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
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
	private String confirmPassword;
	
	public Member(String gssuserid, String email, String userpassword, String userphone, String userName ) {
		this.gssuserId=gssuserid;
		this.email = email;
		this.userPassword = userpassword;
		this.userPhone = userphone;
		this.privilge = userPrivilge;
		this.userName=userName;
	}
	public Member(int gssusernum,String gssuserid, String email, 
			String userpassword, String userphone, String privilge,String username ) {
		this.gssuserNum=gssusernum;
		this.gssuserId=gssuserid;
		this.email=email;
		this.userPassword=userpassword;
		this.userPhone=userphone;
		this.privilge=privilge;
		this.userName=username;
	}
}
