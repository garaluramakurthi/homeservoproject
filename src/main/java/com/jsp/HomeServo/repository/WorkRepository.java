package com.jsp.HomeServo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.dto.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {
	
//	@Query("select a from work a where a.startDate=null")
//	public List<Work> listOfWorks();
//	
//	public List<Work> findAllCustomerId(int id);
	
//	@Query("select a from work a where a.customer.id=59")
//	public List<Work> findById(int id);
//	Customer customer = new Customer();
//	
//	public List<Work> findAllCustomerId(int id);
//	
}
