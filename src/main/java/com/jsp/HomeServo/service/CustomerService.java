package com.jsp.HomeServo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.exception.EmailNotFoundForCustomer;
import com.jsp.HomeServo.exception.NoSuchElementFoundByCustomerIdException;
import com.jsp.HomeServo.exception.PasswordIncorrectException;
import com.jsp.HomeServo.util.ResponseStruture;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	ModelMapper mapper;
	
	
	public ResponseEntity<ResponseStruture<Customer>> saveCustomer(Customer customer){
		ResponseStruture<Customer> struture = new ResponseStruture<Customer>();
		struture.setData(dao.saveCustomer(customer));
		struture.setMessage("Customer Data Saved SuccessFully");
		struture.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStruture<Customer>>(struture,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruture<Customer>> updateCustomer(Customer customer){
		Customer cm = dao.findById(customer.getId());
		if(cm != null) {
			ResponseStruture<Customer> struture = new ResponseStruture<Customer>();
			struture.setData(dao.updateCustomer(customer));
			struture.setMessage("Updation Of The Customer Is Sucessfully Completed");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Customer>>(struture,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundByCustomerIdException("Please enter The Valid Customer ID....");
	}
	
	public ResponseEntity<ResponseStruture<Customer>> deleteCustomer(int id){
		Customer cm = dao.findById(id);
		if(cm != null) {
			ResponseStruture<Customer> struture = new  ResponseStruture<Customer>();
			struture.setData(dao.deleteCustomer(id));
			struture.setMessage("Customer Data Deleted Successfully");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Customer>>(struture,HttpStatus.FOUND);
		}
		else 
			throw new NoSuchElementFoundByCustomerIdException("Please Enter The Valid Customer ID....");
	}
	
//	public ResponseEntity<ResponseStruture<Customer>> findAll(Customer customer){
//		ResponseStruture<Customer> struture = new ResponseStruture<Customer>();
//		struture.setData((Customer) dao.findAll());
//		struture.setMessage("All The Data Is Showed");
//		struture.setStatus(HttpStatus.FOUND.value());
//		
//		return new ResponseEntity<ResponseStruture<Customer>>(struture,HttpStatus.FOUND);
//	}	
	
	public ResponseEntity<ResponseStruture<com.jsp.HomeServo.duplicate.Customer>> findById(int id){
		Customer db = dao.findById(id);
		com.jsp.HomeServo.duplicate.Customer customer = new com.jsp.HomeServo.duplicate.Customer();
		ResponseStruture<com.jsp.HomeServo.duplicate.Customer> struture = new ResponseStruture<com.jsp.HomeServo.duplicate.Customer>();
		if(db != null) {
			
//			customer.setId(db.getId());
//			customer.setName(db.getName());
//			customer.setEmail(db.getEmail());
//			customer.setFamilyCount(db.getFamilyCount());
//			customer.setPhno(db.getPhone());
			
			customer = (com.jsp.HomeServo.duplicate.Customer)this.mapper.map(db, com.jsp.HomeServo.duplicate.Customer.class);
			
			struture.setData(customer);
			struture.setMessage("The Customer Data found...");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<com.jsp.HomeServo.duplicate.Customer>>(struture,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByCustomerIdException("Customer id is not found for your id " +id+" to display");
		}
		
	}
	
	public ResponseEntity<ResponseStruture<Customer>> loginCustomer(String email, String pwd){
		Customer customer = dao.getCustomerByEmail(email);
		if(customer!=null) {
			if(customer.getPwd().equals(pwd)) {
				ResponseStruture<Customer> struture = new ResponseStruture<Customer>();
				struture.setData(customer);
				struture.setMessage("The Customer Login Successfull...");
				struture.setStatus(HttpStatus.FOUND.value());
				
				return new ResponseEntity<ResponseStruture<Customer>>(struture,HttpStatus.FOUND);
			}
			else {
				throw new PasswordIncorrectException("The Entered Password Is Incoorect...");
			}
		}
		else {
			throw new EmailNotFoundForCustomer("Please Enter The Correct Email....");
		}
		
	}
}
