package com.gss.web.common.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.gss.web.api.dto.MemberCreateDto;
import com.gss.web.common.dao.MemberDAO;
import com.gss.web.common.domain.Member;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private final MemberDAO memberDAO;
	
	@Autowired
	private ReloadableResourceBundleMessageSource res;
	
	@Override
	public int joinUp(MemberCreateDto dto) {
		Member member = new Member(dto.getUserid(), dto.getEmail(), dto.getPassword(), dto.getPhoneNumber(),dto.getName());
		int result;
		if (memberDAO.checkEmail(dto.getEmail()) && memberDAO.checkID(dto.getUserid())) {
			throw new IllegalStateException();
		} else {
			result = memberDAO.joinMember(member);
		}
		return result;
	}
	
	@Override
	public Member findByEmail(String email) {
		Member member = memberDAO.findByEmail(email);
		return  member;
	}

	@Override
	public boolean checkEmail(String email) {
		return memberDAO.checkEmail(email);
	}

	@Override
	public boolean checkID(String userid) {
		return memberDAO.checkID(userid);
	}

	@Override
	public boolean checkPhoneNum(String phoneNumber) {
		return memberDAO.checkPhoneNum(phoneNumber);
	}
	@Override
	public int selectLastUserSEQ() {
		return memberDAO.selectLastUserSEQ();
	}
	
	@Override
	public Member findByID(String userid) {
		Member member=memberDAO.findByID(userid);
		return member; 
	}
	
	public Map<String, String> validateNullandEmptyCheck(MemberCreateDto MCRdto){
		Map<String, String> validatorResult = new HashMap<>();
		
		if(MCRdto.getPhoneNumber().isBlank()) {
			String validKeyName = String.format("valid_phoneNumber" );
			validatorResult.put(validKeyName, res.getMessage("Blank.phone", null, null));
		}
		if(MCRdto.getUserid().isBlank()) {
			String validKeyName = String.format("valid_userid" );
			validatorResult.put(validKeyName, res.getMessage("Blank.userid", null, null));
		}
		if(MCRdto.getEmail().isBlank()) {
			String validKeyName = String.format("valid_email" );
			validatorResult.put(validKeyName, res.getMessage("Blank.email", null, null));
		}
		if(MCRdto.getPassword().isBlank()) {
			String validKeyName = String.format("valid_password" );
			validatorResult.put(validKeyName, res.getMessage("Blank.password", null, null));
		}
		if(MCRdto.getConfirmPassword().isBlank()) {
			String validKeyName = String.format("valid_confirmPassword" );
			validatorResult.put(validKeyName, res.getMessage("Blank.password", null, null));
		}
		if(MCRdto.getConfirmPassword().isBlank()) {
			String validKeyName = String.format("valid_confirmPassword" );
			validatorResult.put(validKeyName, res.getMessage("Blank.password", null, null));
		}
		if(!MCRdto.getPassword().equals(MCRdto.getConfirmPassword())) {
			String validKeyName ="valid_confirmPasswordNot";
			validatorResult.put(validKeyName, res.getMessage("Notequal.passwordtoconfirm", null, null));
		}
		
		if(MCRdto.getName().isBlank()){
			String validKeyName ="valid_name";
			validatorResult.put(validKeyName, res.getMessage("Blank.name", null, null));
		}
		
		return validatorResult;
	}
	
	public Map<String, String> validateHandling(BindingResult errors) {
		Map<String, String> validatorResult = new HashMap<>();
		
		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		return validatorResult;
	}
	public Map<String, String> checkEmailandIDandPhoneNum(MemberCreateDto MCRdto){
		Map<String, String> validatorResult = new HashMap<>();
		if (checkEmail(MCRdto.getEmail())) {
			String validKeyName ="valid_alreadyemail";
			validatorResult.put(validKeyName, res.getMessage("already.email", null, null));
		}
		if (checkID(MCRdto.getUserid())) {
			String validKeyName ="valid_alreadyuserid";
			validatorResult.put(validKeyName, res.getMessage("already.userid", null, null));
		}
		if(checkPhoneNum(MCRdto.getPhoneNumber())) {
			String validKeyName ="valid_alreadyPhoneNumber";
			validatorResult.put(validKeyName, res.getMessage("already.phonenumber", null, null));
		}
		return validatorResult;
	}
}
