package com.gss.web.common.dao;

import com.gss.web.common.domain.Member;

public interface MemberDAO {
	int joinMember(Member member);
	
	int editUserInfo(Member member);
	
	Member findByUserPK(int userKey);
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userID);
	
	boolean checkPhoneNum(String phoneNumber);
	
	int selectLastUserSEQ();
}
