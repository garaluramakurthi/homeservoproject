package com.jsp.HomeServo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.AddressDao;
import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.exception.NoSuchElementFoundByAddressIdException;
import com.jsp.HomeServo.util.ResponseStruture;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	public ResponseEntity<ResponseStruture<Address>> updateAddress(Address address){
		Address ad = addressDao.findById(address.getId());
		if(ad != null) {
			ResponseStruture<Address> struture = new ResponseStruture<Address>();
			struture.setData(addressDao.updateAddress(address));
			struture.setMessage("The Address Is Updated Successfully....");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Address>>(struture,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundByAddressIdException("Please Enter The Valid Address ID......");
	}
	
	public ResponseEntity<ResponseStruture<Address>> findById(int id){
		Address ad = addressDao.findById(id);
		if(ad != null) {
			ResponseStruture<Address> struture = new ResponseStruture<Address>();
			struture.setData(addressDao.findById(id));
			struture.setMessage("The Address Of Given Id Is Fetched Successfully...");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<Address>>(struture,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundByAddressIdException("Please Enter The Valid Address ID......");
	}
}
