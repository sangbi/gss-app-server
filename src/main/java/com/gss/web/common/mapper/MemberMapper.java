package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Member;

@Mapper
public interface MemberMapper {
	int joinUp(Member member);
	
	int editUserInfo(Member member);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userID);

	boolean checkPhoneNum(String phoneNumber);
	
	Member findByUserPK(int userKey);
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	List<Map<String, Object>> getMenu(Member member);
	
	void insertLoginHist(Map<String, Object> param);

	List<Map<String, Object>> getAccountAuth(Member member);
}
