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
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.service.WorkService;
import com.jsp.HomeServo.util.ResponseStruture;

@RestController
public class WorkController {
	@Autowired
	private WorkService service;
	
	@PostMapping("/work")
	public ResponseEntity<ResponseStruture<Work>> saveWork(@RequestBody Work work,@RequestParam int cusId){
		return service.saveWork(work, cusId);
	}
	
	@PutMapping("/work/start")
	public ResponseEntity<ResponseStruture<Work>> startWork(@RequestParam int workId,@RequestParam int venId){
		return service.startWork(workId, venId);
	}
	
	@GetMapping("/work/id")
	public ResponseEntity<ResponseStruture<Work>> findById(@RequestParam int id){
		return service.findById(id);
	}
	
	@PutMapping("/work/end")
	public ResponseEntity<ResponseStruture<Work>> endOfWork(@RequestParam int workId, @RequestParam int venId){
		return service.endOfWork(workId, venId);
	}
	
	@PutMapping("/work/update")
	public ResponseEntity<ResponseStruture<Work>> updateWork(@RequestBody Work work){
		return service.updateWork(work);
	}
	
	@GetMapping("/work/all")
	public ResponseEntity<ResponseStruture<List<Work>>> findAll(@RequestParam int venId){
		return service.findAll(venId);
	}
	
	@GetMapping("/work/allc")
	public ResponseEntity<ResponseStruture<List<Work>>> findAllCustomerId(@RequestParam int custId){
		return service.findAllCustomerId(custId);
	}
}
