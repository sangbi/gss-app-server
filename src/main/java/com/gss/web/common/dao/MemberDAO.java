package com.gss.web.common.dao;

import com.gss.web.common.domain.Member;

public interface MemberDAO {
	int joinMember(Member member);
	
	Member findByEmail(String email);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userID);
}
