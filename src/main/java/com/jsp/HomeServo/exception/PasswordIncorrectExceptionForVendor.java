package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class PasswordIncorrectExceptionForVendor extends RuntimeException{
	private String message = "Password Incorrect For The Vendor";

	public PasswordIncorrectExceptionForVendor(String message) {
		super();
		this.message = message;
	}

}
