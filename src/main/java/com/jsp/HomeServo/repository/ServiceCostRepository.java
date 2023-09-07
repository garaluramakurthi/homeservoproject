package com.jsp.HomeServo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HomeServo.dto.ServiceCost;

public interface ServiceCostRepository extends JpaRepository<ServiceCost, Integer> {
	
//	public List<ServiceCost> findById(int custId);
}
