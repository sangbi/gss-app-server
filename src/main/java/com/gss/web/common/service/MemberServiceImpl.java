package com.gss.web.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.web.api.dto.MemberCreateDto.MemberCreateRequest;
import com.gss.web.common.dao.MemberDAO;
import com.gss.web.common.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	@Autowired
	private final MemberDAO memberDAO;

	@Override
	public int joinUp(MemberCreateRequest dto) {
		Member member = new Member(dto.getEmail(), dto.getPassword(), dto.getPhoneNumber());
		if(memberDAO.findByEmail(member.getEmail()) != null) {
			throw new IllegalStateException();
		}
		
		int result = memberDAO.joinMember(member);
		return result;
	}
 
	@Override
	public Member findByEmail(String email) {
		Member member = memberDAO.findByEmail(email);
		return member;
	}

	@Override
	public boolean checkEmail(String email) {
		return memberDAO.checkEmail(email);
	}
}
