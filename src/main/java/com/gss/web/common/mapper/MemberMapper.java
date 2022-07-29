package com.gss.web.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gss.web.common.domain.Member;
import com.gss.web.common.domain.MyInfoList;

@Mapper
public interface MemberMapper {
	int joinUp(Member member);
	
	int editUserInfo(Member member);
	
	List<MyInfoList> findByMyInfoList(int userNum);
	
	List<MyInfoList> findByMyInfoListMember(int userNum);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userID);

	boolean checkPhoneNum(String phoneNumber);

	int checkPartyNick(MyInfoList MIL);
	
	Member findByUserPK(int userKey);
	
	Member findByEmail(String email);
	
	Member findByID(String userid);
	
	List<Map<String, Object>> getMenu(Member member);
	
	void insertLoginHist(Map<String, Object> param);
	
	int updatePartyNick(MyInfoList MIL);

	List<Map<String, Object>> getAccountAuth(Member member);
}
