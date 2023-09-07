package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByWorkIdException extends RuntimeException{
	
	private String message = "There Is No Element Found For The Given Work Id Please Check the Id";

	public NoSuchElementFoundByWorkIdException(String message) {
		super();
		this.message = message;
	}
	
}
