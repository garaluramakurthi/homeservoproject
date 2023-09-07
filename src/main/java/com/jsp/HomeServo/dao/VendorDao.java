package com.jsp.HomeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.repository.VendorRepository;

@Repository
public class VendorDao {
	
	@Autowired
	VendorRepository repository;
	
	public Vendor saveVendor(Vendor vendor) {
		return repository.save(vendor);
	}
	
	public Vendor updateVendor(Vendor vendor) {
		Optional<Vendor> id1 = repository.findById(vendor.getId());
		if(id1.isPresent()) {
			Vendor c2 = id1.get();
			
			if(vendor.getPwd()==null || vendor.getPwd()== "") {
				vendor.setPwd(c2.getPwd());
			}
			if(vendor.getName()==null || vendor.getName()== "") {
				vendor.setName(c2.getName());
			}
			if(vendor.getPhone()==0) {
				vendor.setPhone(c2.getPhone());
			}
			if(vendor.getEmail()==null || vendor.getEmail()== "") {
				vendor.setEmail(c2.getEmail());
			}
			if(vendor.getId()==0) {
				vendor.setId(c2.getId());
			}
			if(vendor.getAddress()==null) {
				vendor.setAddress(c2.getAddress());
			}
			if(vendor.getRole()==null || vendor.getRole()== "") {
				vendor.setRole(c2.getRole());
			}
			if(vendor.getCostPerDay()==0) {
				vendor.setCostPerDay(c2.getCostPerDay());
			}
			if(vendor.getCosts()==null) {
				vendor.setCosts(c2.getCosts());
			}
			
			return repository.save(vendor);
		}
		else
			return null;
	}
	
	public Vendor deleteVendor(int id) {
		Optional<Vendor> id1 = repository.findById(id);
		if(id1.isPresent()) {
			if(id1.isPresent()) {
				repository.delete(id1.get());
			}
			return id1.get();
		}
		else
			return null;
		
	}
	
	public List<Vendor> findAll() {
		return repository.findAll();
	}
	
	public Vendor findById(int id) {
		Optional<Vendor> id1 = repository.findById(id);
		if(id1.isPresent()) {
			return id1.get();
		}
		else
			return null;
	}
	
	
	public Vendor getVendorByEmail(String email) {
		Vendor vendor = repository.findByEmail(email);
		if(vendor != null) {
			return vendor;
		}
		else
			return null;
	}
}
