package com.jsp.HomeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.repository.CustomerRepository;
import com.jsp.HomeServo.repository.WorkRepository;

@Repository
public class WorkDao {
	@Autowired
	WorkRepository repository ;
	CustomerRepository customerRepository;
	
	public Work saveWork(Work work) {
		return repository.save(work);
	}
	
	public Work updateWork(Work work) {
		Optional<Work> id1 = repository.findById(work.getId());
		if(id1.isPresent()) {
			Work work2 = id1.get();
			if(work.getType()== "") {
				work.setType(work2.getType());
			}
			if(work.getStartDate()==null) {
				work.setStartDate(work2.getStartDate());
			}
			if(work.getEndDate()==null) {
				work.setEndDate(work2.getEndDate());
			}
			if(work.getAddress()==null) {
				work.setAddress(work2.getAddress());
			}
			if(work.getVendors()==null) {
				work.setVendors(work2.getVendors());
			}
			if(work.getCustomer()==null) {
				work.setCustomer(work2.getCustomer());
			}
			if(work.getCost()==null) {
				work.setCost(work2.getCost());
			}
			return repository.save(work);
		}
		else
			return null;
	}
	
	public Work findById(int id) {
		Optional<Work> id1 = repository.findById(id);
		if(id1.isPresent()) {
			return id1.get();
		}
		else
			return null;
	}
	
	public List<Work> findAll(){
		return repository.findAll();
	}
	public List<Work> findAllCustomerId(int id){
//		Optional<Customer> cust = customerRepository.findById(id);
//		if(cust.isPresent()) {
//			return repository.findAllCustomerId(id);
//			System.out.println(repository.findAll());
			return repository.findAll();
			
//		}
//		else
//			return null;
	}
}
