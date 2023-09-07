package com.jsp.HomeServo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.service.CustomerService;
import com.jsp.HomeServo.util.ResponseStruture;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;


	@PostMapping("/customer")
	public ResponseEntity<ResponseStruture<Customer>> saveCustomer(@RequestBody Customer customer){
		return service.saveCustomer(customer);
	}
	

	@PutMapping("/customer")
	public ResponseEntity<ResponseStruture<Customer>> updateCustomer(@RequestBody Customer customer){
		return service.updateCustomer(customer);
	}
	

	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStruture<Customer>> deleteCustomer(@RequestParam int id){
		return service.deleteCustomer(id);
	}
	
//	@GetMapping("/findAllCustomer")
//	public ResponseEntity<ResponseStruture<Customer>> findAll(@RequestBody Customer customer){
//		return service.findAll(customer);		
//	}

	@GetMapping("/customer/id")
	public ResponseEntity<ResponseStruture<com.jsp.HomeServo.duplicate.Customer>> findById(@RequestParam int id){
		return service.findById(id);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<ResponseStruture<Customer>> loginCustomer(@RequestParam String email,@RequestParam String pwd){
		return service.loginCustomer(email, pwd);
	}
}
