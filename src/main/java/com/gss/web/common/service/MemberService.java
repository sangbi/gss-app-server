package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.common.domain.Member;
import com.gss.web.common.domain.MyInfoList;

public interface MemberService {
	int joinUp(MemberCreateDto dto);
	
	int editUserInfo(MemberCreateDto dto);
	
	void updatePartyNick(MyInfoList MIL);
	
	List<MyInfoList> findByMyInfoList(int userNum);
	
	List<MyInfoList> findByMyInfoListMember(int userNum);
	
	Member findByUserPK(int userKey); 
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userid);
	
	boolean checkPhoneNum(String phoneNumber);
	
	int checkPartyNick(MyInfoList MIL);
	
	int selectLastUserSEQ();
}
