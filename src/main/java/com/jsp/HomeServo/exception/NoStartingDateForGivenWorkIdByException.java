package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class NoStartingDateForGivenWorkIdByException extends RuntimeException{
	
	private String message = "There Is No Start Date For Given Work Id Please Check the Id";

	public NoStartingDateForGivenWorkIdByException(String message) {
		super();
		this.message = message;
	}
	
}
