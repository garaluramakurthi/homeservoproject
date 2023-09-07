package com.jsp.HomeServo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.HomeServo.dto.ServiceCost;
import com.jsp.HomeServo.service.ServiceCostService;
import com.jsp.HomeServo.util.ResponseStruture;

@Controller
public class ServiceCostController {
		
	@Autowired
	ServiceCostService costService;
	
	@PostMapping("/serviceCost")
	public ResponseEntity<ResponseStruture<ServiceCost>> saveServiceCost(@RequestParam int workId,@RequestParam int venId){
		return costService.saveServiceCost(workId, venId);
	}
	
	@PutMapping("/serviceCost")
	public ResponseEntity<ResponseStruture<ServiceCost>> paymentMode (@RequestParam int cusId ,@RequestBody ServiceCost cost){
		return costService.paymentMode(cusId, cost);
	}
	
}
