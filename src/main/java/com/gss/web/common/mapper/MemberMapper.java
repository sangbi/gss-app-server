package com.gss.web.common.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Member;

@Mapper
public interface MemberMapper {
	int joinUp(Member member);

	boolean checkEmail(String email);
	
	boolean checkID(String userID);

	Member findByEmail(String email);
	
	Member findByID(String userid);
}
