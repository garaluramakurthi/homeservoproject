package com.jsp.HomeServo.service;

import java.sql.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.ServiceCostDao;
import com.jsp.HomeServo.dao.VendorDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.ServiceCost;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.exception.NoSuchElementFoundByCustomerIdException;
import com.jsp.HomeServo.exception.NoSuchElementFoundByServiceCostIdException;
import com.jsp.HomeServo.exception.NoSuchElementFoundByVendorIdException;
import com.jsp.HomeServo.exception.NoSuchElementFoundByWorkIdException;
import com.jsp.HomeServo.util.ResponseStruture;

@Service
public class ServiceCostService {
	
	@Autowired
	VendorDao vendorDao;
	
	@Autowired
	WorkDao workDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ServiceCostDao costDao;
	
//	public ResponseEntity<ResponseStruture<ServiceCost>> saveServiceCost(int workId, int venId){
//		Vendor vendor = vendorDao.findById(venId);
//		if(vendor != null) {
//			Work work = workDao.findById(workId);
//			if(work != null && work.getCost() == null) {
//				double costPerDay = vendor.getCostPerDay();
//				
//				Date start = work.getStartDate();
//				Date end = work.getEndDate();
//				
//				Duration duration = Duration.between(start.toLocalDate().atStartOfDay(), end.toLocalDate().atStartOfDay());
//				
//				int days = (int)duration.toDays();
//				cost.setDays(days);
//				cost.setTotalAmount(days*costPerDay);
//				ServiceCost cost2 = costDao.saveServiceCost(cost);
//				
//				work.setCost(cost2);
//				List<ServiceCost> list = new ArrayList<ServiceCost>();
//				list.add(cost2);
//				list.addAll(vendor.getCosts());
//				
//				vendor.setCosts(list);
////				vendorDao.updateVendor(vendor);
//				workDao.updateWork(work);
//				
//				ResponseStruture<ServiceCost> struture = new ResponseStruture<ServiceCost>();
//				struture.setData(cost2);
//				struture.setMessage("Cost Saved Successfully..");
//				struture.setStatus(HttpStatus.CREATED.value());
//				
//				return new ResponseEntity<ResponseStruture<ServiceCost>>(struture,HttpStatus.CREATED);
//				
//						
//			}
//			else {
//				throw new NoSuchElementFoundByWorkIdException("There Is No Work Present With The Given Work Id...");
//			}
//		}
//		else {
//			throw new NoSuchElementFoundByVendorIdException("There Is No Vendor Present With The Given Vandor Id...");
//		}
//	}
	
	public ResponseEntity<ResponseStruture<ServiceCost>> saveServiceCost(int workId, int venId) {
	    Vendor vendor = vendorDao.findById(venId);
	    
	    if (vendor != null) {
	        Work work = workDao.findById(workId);
	        
	        if (work != null && work.getCost() == null) {
	            double costPerDay = vendor.getCostPerDay();
	            Date start = work.getStartDate();
	            Date end = work.getEndDate();
	            Duration duration = Duration.between(start.toLocalDate().atStartOfDay(), end.toLocalDate().atStartOfDay());
	            int days = (int) duration.toDays();

	            // Create a new ServiceCost object for each entry
	            ServiceCost cost = new ServiceCost();
	            cost.setDays(days);
	            cost.setTotalAmount(days * costPerDay);

	            // Save the new ServiceCost object
	            ServiceCost savedCost = costDao.saveServiceCost(cost);

	            work.setCost(savedCost);
	            List<ServiceCost> list = new ArrayList<>();
	            list.add(savedCost);
	            list.addAll(vendor.getCosts());

	            vendor.setCosts(list);
	            workDao.updateWork(work);

	            ResponseStruture<ServiceCost> struture = new ResponseStruture<>();
	            struture.setData(savedCost);
	            struture.setMessage("Cost Saved Successfully..");
	            struture.setStatus(HttpStatus.CREATED.value());

	            return new ResponseEntity<>(struture, HttpStatus.CREATED);
	        } else {
	            throw new NoSuchElementFoundByWorkIdException("There Is No Work Present With The Given Work Id...");
	        }
	    } else {
	        throw new NoSuchElementFoundByVendorIdException("There Is No Vendor Present With The Given Vendor Id...");
	    }
	}

	
	public ResponseEntity<ResponseStruture<ServiceCost>> paymentMode(int cusId , ServiceCost cost){
		Customer customer = customerDao.findById(cusId);
		if(customer != null) {
			ServiceCost cost2 = costDao.findById(cost.getId());
			if(cost2 != null) {
				ResponseStruture<ServiceCost> struture = new ResponseStruture<ServiceCost>();
				struture.setData(costDao.paymentMode(cost));
				struture.setMessage("PaymentMode Saved Successfully..");
				struture.setStatus(HttpStatus.CREATED.value());
				
				return new ResponseEntity<ResponseStruture<ServiceCost>>(struture,HttpStatus.CREATED);
			}
			else {
				throw new NoSuchElementFoundByServiceCostIdException("Plese Enter The Valid Service Cost Id...");
			}
		}
		else {
			throw new NoSuchElementFoundByCustomerIdException("Plese Enter The Valid Customer Id....");
		}
	}
	
	
	
	
	
}
