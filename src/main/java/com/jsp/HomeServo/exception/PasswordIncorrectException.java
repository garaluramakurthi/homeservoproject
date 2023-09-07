package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class PasswordIncorrectException extends RuntimeException{
	private String message = "Password Incorrect For The User";

	public PasswordIncorrectException(String message) {
		super();
		this.message = message;
	}

}
