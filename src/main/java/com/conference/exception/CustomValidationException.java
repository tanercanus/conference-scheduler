package com.conference.exception;

import ch.qos.logback.core.joran.spi.ActionException;

public class CustomValidationException extends ActionException {

	private static final long serialVersionUID = 7358559408036481189L;
	int exceptionType;

	public CustomValidationException(int exceptionType) {
		super();
		this.exceptionType = exceptionType;
	}

	public int getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(int exceptionType) {
		this.exceptionType = exceptionType;
	}

}
