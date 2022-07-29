package com.gss.web.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.common.domain.Member;
import com.gss.web.common.domain.MyInfoList;
import com.gss.web.common.mapper.MemberMapper;
import com.gss.web.common.mapper.UserSEQMapper;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int joinMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).joinUp(member);
	}

	@Override
	public int editUserInfo(Member member) {
		return sqlSession.getMapper(MemberMapper.class).editUserInfo(member);
	}
	
	@Override
	public Member findByUserPK(int userKey) {
		return sqlSession.getMapper(MemberMapper.class).findByUserPK(userKey);
	}
	
	@Override
	public Member findByEmail(String email) {
		return sqlSession.getMapper(MemberMapper.class).findByEmail(email);
	}

	@Override
	public boolean checkEmail(String email) {
		return sqlSession.getMapper(MemberMapper.class).checkEmail(email);
	}

	@Override
	public boolean checkID(String userID) {
		return sqlSession.getMapper(MemberMapper.class).checkID(userID);
	}

	@Override
	public boolean checkPhoneNum(String phoneNumber) {
		return sqlSession.getMapper(MemberMapper.class).checkPhoneNum(phoneNumber);
	}
	@Override
	public Member findByID(String userid) {
		return sqlSession.getMapper(MemberMapper.class).findByID(userid);
	}

	@Override
	public int selectLastUserSEQ() {
		return sqlSession.getMapper(UserSEQMapper.class).selectLastUserSEQ();
	}

	@Override
	public List<MyInfoList> findByMyInfoList(int userNum) {
		return sqlSession.getMapper(MemberMapper.class).findByMyInfoList(userNum);
	}

	@Override
	public List<MyInfoList> findByMyInfoListMember(int userNum) {
		return sqlSession.getMapper(MemberMapper.class).findByMyInfoListMember(userNum);
	}

	@Override
	public int checkPartyNick(MyInfoList MIL) {
		return sqlSession.getMapper(MemberMapper.class).checkPartyNick(MIL);
	}

	@Override
	public void updatePartyNick(MyInfoList MIL) {
		sqlSession.getMapper(MemberMapper.class).updatePartyNick(MIL);
	}
}
