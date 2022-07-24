package com.gss.web.common.customexception;

public class SocialLoginEmailNotMatchingException extends RuntimeException  {
	public SocialLoginEmailNotMatchingException(String message) {
		super(message);
	}
}
