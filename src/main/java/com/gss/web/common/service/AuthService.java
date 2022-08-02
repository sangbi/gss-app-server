package com.gss.web.common.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.gss.web.api.dto.AuthInfo;
import com.gss.web.common.customexception.IdPasswordNotMatchingException;
import com.gss.web.common.dao.MemberDAO;
import com.gss.web.common.domain.Member;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	@Autowired
	private final MemberDAO memberDao;

	public AuthInfo authenticate(String userid, String password) {
		Member member = memberDao.findByID(userid);

		if (member == null) {
			throw new IdPasswordNotMatchingException("{IdPasswordNotMatching}");
		} else if (!member.getUserPassword().equals(password)) {
			throw new IdPasswordNotMatchingException("dddd");
		}

		return new AuthInfo(member.getGssuserNum(),member.getGssuserId(), member.getPrivilge());
		//return new AuthInfo(String.valueOf(member.getGssuserNum()),member.getGssuserId());
	}
	
	public AuthInfo authenticateEmail(String email) {
		Member member = memberDao.findByEmail(email);

		if (member == null) {
			throw new IdPasswordNotMatchingException("{IdPasswordNotMatching}");
		}

		return new AuthInfo(Integer.valueOf(member.getGssuserId()), member.getEmail(), member.getPrivilge());
	}
	
	public Map<String, String> validateHandling(BindingResult errors) {
		Map<String, String> validatorResult = new HashMap<>();

		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}

		return validatorResult;
	}
}