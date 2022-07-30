package com.gss.web.common.dao;

import java.util.List;

import com.gss.web.common.domain.Member;
import com.gss.web.common.domain.MyInfoList;

public interface MemberDAO {
	int joinMember(Member member);
	
	void updatePartyNick(MyInfoList MIL);
	
	int editUserInfo(Member member);
	
	List<MyInfoList> findByMyInfoList(int userNum);
	
	List<MyInfoList> findByMyInfoListMember(int userNum);
	
	Member findByUserPK(int userKey);
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userID);
	
	boolean checkPhoneNum(String phoneNumber);
	
	int checkPartyNick(MyInfoList MIL);
	
	int selectLastUserSEQ();
}
