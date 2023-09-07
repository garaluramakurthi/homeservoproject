package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByVendorIdException extends RuntimeException{
	
	private String message = "There Is No Element Found For The Given Vendor Id Please Check the Id";

	public NoSuchElementFoundByVendorIdException(String message) {
		super();
		this.message = message;
	}
	
}
