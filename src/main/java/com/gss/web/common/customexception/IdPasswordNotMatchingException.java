package com.gss.web.common.customexception;

public class IdPasswordNotMatchingException extends RuntimeException {
	public IdPasswordNotMatchingException(String message) {
		super(message);
	}
}