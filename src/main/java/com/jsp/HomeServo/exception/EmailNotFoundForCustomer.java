package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class EmailNotFoundForCustomer extends RuntimeException{
	private String message = "Email Not Found For The User";

	public EmailNotFoundForCustomer(String message) {
		super();
		this.message = message;
	}
	
}
