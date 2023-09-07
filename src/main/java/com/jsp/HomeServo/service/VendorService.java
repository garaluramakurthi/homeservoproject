package com.jsp.HomeServo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.VendorDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.exception.EmailNotFoundForCustomer;
import com.jsp.HomeServo.exception.NoSuchElementFoundByCustomerIdException;
import com.jsp.HomeServo.exception.PasswordIncorrectException;
import com.jsp.HomeServo.util.ResponseStruture;

@Service
public class VendorService {

	@Autowired
	private VendorDao dao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStruture<Vendor>> saveVendor(Vendor vendor){
		ResponseStruture<Vendor> struture = new ResponseStruture<Vendor>();
		struture.setData(dao.saveVendor(vendor));
		struture.setMessage("Vendor Saved Sucessfully");
		struture.setStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStruture<Vendor>>(struture,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruture<Vendor>> updateVendor(Vendor vendor){
		Vendor vn = dao.findById(vendor.getId());
		if(vn != null) {
			ResponseStruture<Vendor> struture = new ResponseStruture<Vendor>();
			struture.setData(dao.updateVendor(vendor));
			struture.setMessage("Updation Of The Vendor Is Sucessfully Completed");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Vendor>>(struture,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundByCustomerIdException("Vendor id is not found for your id " +vendor.getId()+" to display");
	}
	
	public ResponseEntity<ResponseStruture<Vendor>> deleteVendor(int id){
		Vendor vn = dao.findById(id);
		if(vn != null) {
			ResponseStruture<Vendor> struture = new  ResponseStruture<Vendor>();
			struture.setData(dao.deleteVendor(id));
			struture.setMessage("Vendor Data Deleted Successfully");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Vendor>>(struture,HttpStatus.FOUND);
		}
		throw new NoSuchElementFoundByCustomerIdException("Vendor id is not found for your id " +id+" to display");
	}
	
	public ResponseEntity<ResponseStruture<List<Vendor>>> findAll(int custId){
		Customer customer = customerDao.findById(custId);
		if(customer != null) {
			List<Vendor> list = dao.findAll();
			ResponseStruture<List<Vendor>> struture = new ResponseStruture<List<Vendor>>();
			struture.setData(list);
			struture.setMessage("All The Data Is Showed");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<List<Vendor>>>(struture,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundByCustomerIdException("Please Enter The Valid Customer ID..");
	}	
	
	public ResponseEntity<ResponseStruture<Vendor>> findById(int id){
		Vendor db = dao.findById(id);
		ResponseStruture<Vendor> struture = new ResponseStruture<Vendor>();
		if(db != null) {
			struture.setData(dao.findById(id));
			struture.setMessage("The Vendor Data found...");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Vendor>>(struture,HttpStatus.FOUND);
		}
		else {
			throw new NoSuchElementFoundByCustomerIdException("Vendor id is not found for your id " +id+" to display");
		}
		
	}
	
	public ResponseEntity<ResponseStruture<Vendor>> loginVendor(String email, String pwd){
		Vendor vendor = dao.getVendorByEmail(email);
		if(vendor!=null) {
			if(vendor.getPwd().equals(pwd)) {
				ResponseStruture<Vendor> struture = new ResponseStruture<Vendor>();
				struture.setData(vendor);
				struture.setMessage("The Vendor Login Successfull...");
				struture.setStatus(HttpStatus.FOUND.value());
				
				return new ResponseEntity<ResponseStruture<Vendor>>(struture,HttpStatus.FOUND);
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
