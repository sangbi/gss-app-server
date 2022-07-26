package com.gss.web.common.service;

import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.common.domain.Member;

public interface MemberService {
	int joinUp(MemberCreateDto dto);
	
	int editUserInfo(MemberCreateDto dto);
	
	Member findByUserPK(int userKey); 
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userid);
	
	boolean checkPhoneNum(String phoneNumber);
	
	int selectLastUserSEQ();
}
