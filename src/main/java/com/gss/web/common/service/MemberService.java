package com.gss.web.common.service;

import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.common.domain.Member;

public interface MemberService {
	int joinUp(MemberCreateDto dto);

	Member findByEmail(String email);
	
	boolean checkEmail(String email);
	
	boolean checkID(String userid);
}
