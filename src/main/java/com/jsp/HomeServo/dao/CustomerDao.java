package com.jsp.HomeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.repository.AddressRepository;
import com.jsp.HomeServo.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;
	AddressRepository addressRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		Optional<Customer> id1 = customerRepository.findById(customer.getId());
		if (id1.isPresent()) {
			Customer c2 = id1.get();

			if (customer.getPwd() == "" || customer.getPwd() == null) {
				customer.setPwd(c2.getPwd());
			}
			if (customer.getName() == "" || customer.getName() == null) {
				customer.setName(c2.getName());
			}
			if (customer.getFamilyCount() == 0) {
				customer.setFamilyCount(c2.getFamilyCount());
			}
			if (customer.getPhone() == 0) {
				customer.setPhone(c2.getPhone());
			}
			if (customer.getEmail() == null || customer.getEmail() == "") {
				customer.setEmail(c2.getEmail());
			}
			if (customer.getId() == 0) {
				customer.setId(c2.getId());
			}
			if (customer.getAddress() == null) {
				customer.setAddress(c2.getAddress());
//				if(customer.getAddress().getDoorNo() != null) {
//					Address address = customer.getAddress();
//					address.setDoorNo(customer.getAddress().getDoorNo());
//					address.setId(customer.getAddress().getId());
//					address.setDistrict(customer.getAddress().getDistrict());
//					address.setLandmark(customer.getAddress().getLandmark());
//					address.setPincode(customer.getAddress().getPincode());
//					address.setState(customer.getAddress().getState());
//					address.setStreet(customer.getAddress().getStreet());
//					customer.setAddress(address);
//				}
			}
			
			if (customer.getWorks() == null) {
				customer.setWorks(c2.getWorks());
			}

			return customerRepository.save(customer);
		} else
			return null;
	}

	public Customer deleteCustomer(int id) {
		Optional<Customer> id1 = customerRepository.findById(id);
		if (id1.isPresent()) {
			customerRepository.delete(id1.get());
			return id1.get();
		} else
			return null;

	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(int id) {
		Optional<Customer> id1 = customerRepository.findById(id);
		if (id1.isPresent()) {
			return id1.get();
		} else
			return null;
	}

	public Customer getCustomerByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if (customer != null) {
			return customer;
		} else
			return null;
	}
}
