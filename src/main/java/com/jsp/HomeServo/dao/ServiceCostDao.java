package com.jsp.HomeServo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.ServiceCost;
import com.jsp.HomeServo.repository.CustomerRepository;
import com.jsp.HomeServo.repository.ServiceCostRepository;

@Service
public class ServiceCostDao {
	
	@Autowired
	ServiceCostRepository costRepository;
	
	@Autowired 
	CustomerRepository customerRepository;
	
	public ServiceCost saveServiceCost(ServiceCost cost) {
		return costRepository.save(cost);
	}
	
	public ServiceCost findById(int id) {
		ServiceCost serviceCost = costRepository.findById(id).get();
		if(serviceCost != null) {
			return serviceCost;
		}
		else
			return null;
	}
	
	public ServiceCost paymentMode(ServiceCost cost) {
		Optional<ServiceCost> optional = costRepository.findById(cost.getId());
		if(optional.isPresent()) {
			ServiceCost serviceCost = costRepository.findById(cost.getId()).get();
			if(cost.getDays() == 0) {
				cost.setDays(serviceCost.getDays());
			}
			if(cost.getTotalAmount() == 0.0) {
				cost.setTotalAmount(serviceCost.getTotalAmount());
			}
			if(cost.getMode() == "" || cost.getMode() == null) {
				cost.setMode(serviceCost.getMode());
			}
			return costRepository.save(cost);
				
		}
		else
			return null;
	}
	
}
