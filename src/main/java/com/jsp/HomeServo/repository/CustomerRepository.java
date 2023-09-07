package com.jsp.HomeServo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HomeServo.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByEmail(String email);
}
