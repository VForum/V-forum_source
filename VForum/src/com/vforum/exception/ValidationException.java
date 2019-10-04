package com.vforum.exception;

public class ValidationException extends Exception {
	
	private String message;

	public ValidationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
