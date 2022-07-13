package com.gss.web.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gss.web.common.domain.Member;
import com.gss.web.common.mapper.MemberMapper;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int joinMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).joinUp(member);
		
	}
	
	@Override
	public Member findByEmail(String email) {
		return sqlSession.getMapper(MemberMapper.class).findByEmail(email);
	}

	@Override
	public boolean checkEmail(String email) {
		return sqlSession.getMapper(MemberMapper.class).checkEmail(email);
	}
}
