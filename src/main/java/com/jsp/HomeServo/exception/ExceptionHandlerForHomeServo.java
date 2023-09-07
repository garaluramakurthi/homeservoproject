package com.jsp.HomeServo.exception;

import java.security.DrbgParameters.Reseed;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.util.ResponseStruture;
@ControllerAdvice
public class ExceptionHandlerForHomeServo extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStruture<String>> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("Duplicate Mail Address Found...");
		struture.setMessage(ex.getMessage());
		struture.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotFoundForCustomer.class)
	public ResponseEntity<ResponseStruture<String>> emailNotFoundForCustomer(EmailNotFoundForCustomer em){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("Email Not Found For The User...");
		struture.setMessage(em.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundForVendor.class)
	public ResponseEntity<ResponseStruture<String>> emailNotFoundForVendor(EmailNotFoundForVendor em){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("Email Not Found For The Vendor...");
		struture.setMessage(em.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PasswordIncorrectException.class)
	public ResponseEntity<ResponseStruture<String>> passwordIncorrectException(PasswordIncorrectException pwd){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("Password Not Found For The User...");
		struture.setMessage(pwd.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PasswordIncorrectExceptionForVendor.class)
	public ResponseEntity<ResponseStruture<String>> PasswordIncorrectExceptionForVendor(PasswordIncorrectExceptionForVendor pwd){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("Password Not Found For The Vendor...");
		struture.setMessage(pwd.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NoSuchElementFoundByCustomerIdException.class)
	public ResponseEntity<ResponseStruture<String>> noSuchElementFoundByCustomerIdException(NoSuchElementFoundByCustomerIdException no){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("No Element Found With The Given Customer Id...");
		struture.setMessage(no.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(NoSuchElementFoundByAddressIdException.class)
	public ResponseEntity<ResponseStruture<String>> noSuchElementFoundByAddressIdException(NoSuchElementFoundByAddressIdException no){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("No Element Found With The Given Address Id...");
		struture.setMessage(no.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NoSuchElementFoundByServiceCostIdException.class)
	public ResponseEntity<ResponseStruture<String>> noSuchElementFoundByServiceCostIdException(NoSuchElementFoundByServiceCostIdException no){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("No Element Found With The Given ServiceCost Id...");
		struture.setMessage(no.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(NoStartingDateForGivenWorkIdByException.class)
	public ResponseEntity<ResponseStruture<String>> noStartingDateForGivenWorkIdByException(NoStartingDateForGivenWorkIdByException no){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("There Is No Starting Date For The Given Work ID...");
		struture.setMessage(no.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(NoSuchElementFoundByVendorIdException.class)
	public ResponseEntity<ResponseStruture<String>> noSuchElementFoundByVendorIdException(NoSuchElementFoundByVendorIdException no){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("No Element Found With The Given Vendor Id...");
		struture.setMessage(no.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(NoSuchElementFoundByWorkIdException.class)
	public ResponseEntity<ResponseStruture<String>> noSuchElementFoundByWorkIdException(NoSuchElementFoundByWorkIdException no){
		ResponseStruture<String> struture = new ResponseStruture<String>();
		struture.setData("No Element Found With The Given Work Id...");
		struture.setMessage(no.getMessage());
		struture.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStruture<String>>(struture,HttpStatus.NOT_FOUND);
	}
	
}
