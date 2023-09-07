package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class EmailNotFoundForVendor extends RuntimeException{
	private String message = "Email Not Found For The Vendor";

	public EmailNotFoundForVendor(String message) {
		super();
		this.message = message;
	}
	
}
