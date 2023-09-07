package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByCustomerIdException extends RuntimeException{
	
	private String message = "There Is No Element Found For The Given Customer Id Please Check the Id";

	public NoSuchElementFoundByCustomerIdException(String message) {
		super();
		this.message = message;
	}
	
}
