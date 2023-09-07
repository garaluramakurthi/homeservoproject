	package com.jsp.HomeServo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.service.VendorService;
import com.jsp.HomeServo.util.ResponseStruture;

@RestController
public class VendorController {
	
	@Autowired
	private VendorService service;
	
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/vendor")
	public ResponseEntity<ResponseStruture<Vendor>> saveVendor(@RequestBody Vendor vendor){
		return service.saveVendor(vendor);
	}
	
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PutMapping("/vendor")
	public ResponseEntity<ResponseStruture<Vendor>> updateVendor(@RequestBody Vendor vendor){
		return service.updateVendor(vendor);
	}
	
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@DeleteMapping("/vendor")
	public ResponseEntity<ResponseStruture<Vendor>> deleteVendor(@RequestParam int id){
		return service.deleteVendor(id);
	}
	
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/vendor/all")
	public ResponseEntity<ResponseStruture<List<Vendor>>> findAll(@RequestParam int custId){
		return service.findAll(custId);	
	}
	
	@GetMapping("/vendor/id")
	public ResponseEntity<ResponseStruture<Vendor>> findById(@RequestParam int id){
		return service.findById(id);
	}
	
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/vendor")
	public ResponseEntity<ResponseStruture<Vendor>> loginVendor(@RequestParam String email,@RequestParam String pwd){
		return service.loginVendor(email, pwd);
	}
	
	
}
