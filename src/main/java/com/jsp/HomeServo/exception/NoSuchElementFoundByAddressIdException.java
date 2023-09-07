package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByAddressIdException extends RuntimeException{
	
	private String message = "There Is No Element Found For The Given Address Id Please Check the Id";

	public NoSuchElementFoundByAddressIdException(String message) {
		super();
		this.message = message;
	}
	
}
