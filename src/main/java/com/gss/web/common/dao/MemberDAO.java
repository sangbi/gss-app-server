package com.gss.web.common.dao;

import java.util.List;
import java.util.Map;

import com.gss.web.common.domain.Member;

public interface MemberDAO {
	int joinMember(Member member);
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userID);
	
	int selectLastUserSEQ();
}
