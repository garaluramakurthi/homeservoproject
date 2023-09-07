package com.jsp.HomeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByServiceCostIdException extends RuntimeException{
	
	private String message = "There Is No Element Found For The Given ServiceCost Id Please Check the Id";

	public NoSuchElementFoundByServiceCostIdException(String message) {
		super();
		this.message = message;
	}
	
}
