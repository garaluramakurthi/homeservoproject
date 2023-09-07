package com.jsp.HomeServo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepository addressRepository;
	
	public Address updateAddress(Address address) {
		Optional<Address> ad = addressRepository.findById(address.getId());
		if(ad.isPresent()) {
			Address address2 = ad.get();
			
			if(address.getDoorNo()==null || address.getDoorNo()== "") {
				address.setDoorNo(address2.getDoorNo());
			}
			if(address.getStreet()==null || address.getStreet()=="") {
				address.setStreet(address2.getStreet());
			}
			if(address.getDistrict()==null || address.getDistrict()=="") {
				address.setDistrict(address2.getDistrict());
			}
			if(address.getLandmark()==null || address.getLandmark()=="") {
				address.setLandmark(address2.getLandmark());
			}
			if(address.getState()==null || address.getState()=="") {
				address.setState(address2.getState());
			}
			if(address.getPincode()==0) {
				address.setPincode(address2.getPincode());
			}
			return addressRepository.save(address);
		}
		else
			return null;
	}
	
	public Address findById(int id) {
		Optional<Address> ad = addressRepository.findById(id);
		if(ad.isPresent()) {
			return ad.get();
		}
		else
			return null;
	}
	
}
