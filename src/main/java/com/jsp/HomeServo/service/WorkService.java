package com.jsp.HomeServo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.HomeServo.dao.CustomerDao;
import com.jsp.HomeServo.dao.VendorDao;
import com.jsp.HomeServo.dao.WorkDao;
import com.jsp.HomeServo.dto.Customer;
import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.exception.NoStartingDateForGivenWorkIdByException;
import com.jsp.HomeServo.exception.NoSuchElementFoundByCustomerIdException;
import com.jsp.HomeServo.exception.NoSuchElementFoundByVendorIdException;
import com.jsp.HomeServo.exception.NoSuchElementFoundByWorkIdException;
import com.jsp.HomeServo.util.ResponseStruture;

@Service
public class WorkService {
	@Autowired
	private WorkDao dao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private VendorDao vendorDao;

	public ResponseEntity<ResponseStruture<Work>> saveWork(Work work, int cusId) {
		Customer cu = customerDao.findById(cusId);
		if (cu != null) {
//			saving the Customer to the work before saving the work to the db
			work.setCustomer(cu);
			ResponseStruture<Work> struture = new ResponseStruture<Work>();
			struture.setData(dao.saveWork(work));
			struture.setMessage("Work Saved Successfully....");
			struture.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStruture<Work>>(struture, HttpStatus.CREATED);
		} else
			throw new NoSuchElementFoundByCustomerIdException("Please Enter The Valid Customer ID...");
	}

	public ResponseEntity<ResponseStruture<Work>> startWork(int workId, int venId) {
		Vendor vendor = vendorDao.findById(venId);
		if (vendor != null) {
			Work work = dao.findById(workId);
			if (work != null) {
				Date date = new Date(new java.util.Date().getTime());
				work.setStartDate(date);
				List<Vendor> list = new ArrayList<Vendor>();
				list.add(vendor);
				work.setVendors(list);

				ResponseStruture<Work> struture = new ResponseStruture<Work>();
				struture.setData(dao.updateWork(work));
				struture.setMessage("Work Updated Successfully....");
				struture.setStatus(HttpStatus.FOUND.value());

				return new ResponseEntity<ResponseStruture<Work>>(struture, HttpStatus.FOUND);

			} else
				throw new NoSuchElementFoundByWorkIdException("Please Enter The Valid Work ID ....");
		} else
			throw new NoSuchElementFoundByVendorIdException("Please Enter The Valid Vendor ID....");
	}

	public ResponseEntity<ResponseStruture<Work>> endOfWork(int workId, int venId) {
		Vendor vendor = vendorDao.findById(venId);
		if (vendor != null) {
			Work work = dao.findById(workId);

			if (work.getStartDate() != null) {
				if (work != null) {
					Date date = new Date(new java.util.Date().getTime());
					work.setEndDate(date);
					List<Vendor> list = new ArrayList<Vendor>();
					list.add(vendor);
					work.setVendors(list);
					ResponseStruture<Work> struture = new ResponseStruture<Work>();
					struture.setData(dao.updateWork(work));
					struture.setMessage("Work Updated Successfully....");
					struture.setStatus(HttpStatus.FOUND.value());

					return new ResponseEntity<ResponseStruture<Work>>(struture, HttpStatus.FOUND);

				}
				else 
					throw new NoStartingDateForGivenWorkIdByException("There Is No Start Date For The Given Work ID...");
			} else
				throw new NoSuchElementFoundByWorkIdException("Please Enter The Valid Work ID ....");

		} else
			throw new NoSuchElementFoundByVendorIdException("Please Enter The Valid Vendor ID....");

	}

	public ResponseEntity<ResponseStruture<Work>> findById(int id) {
		Work db = dao.findById(id);
		ResponseStruture<Work> struture = new ResponseStruture<Work>();
		if (db != null) {
			struture.setData(dao.findById(id));
			struture.setMessage("The Work Data found...");
			struture.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStruture<Work>>(struture, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementFoundByWorkIdException("Work id is not found for your id " + id + " to display");
		}
	}

	public ResponseEntity<ResponseStruture<Work>> updateWork(Work work) {
		Work db = dao.findById(work.getId());
		if (db != null) {
			ResponseStruture<Work> struture = new ResponseStruture<Work>();
			struture.setData(dao.updateWork(work));
			struture.setMessage("The Work Is Updated Successfully...");
			struture.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStruture<Work>>(struture, HttpStatus.FOUND);
		} else
			throw new NoSuchElementFoundByWorkIdException("Please Enter the Valid Work ID .....");
	}
	
	
	public ResponseEntity<ResponseStruture<List<Work>>> findAll(int venId){
		Vendor vendor = vendorDao.findById(venId);
		if(vendor != null) {
			List<Work> list = dao.findAll();
			ResponseStruture<List<Work>> struture = new ResponseStruture<List<Work>>();
			struture.setData(list);
			struture.setMessage("All The Works Are Displayed Above....");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<List<Work>>>(struture,HttpStatus.FOUND);
			
		}
		else
			throw new NoSuchElementFoundByVendorIdException("Please Enter The Valid Vendor Id....");
	}
	
	public ResponseEntity<ResponseStruture<List<Work>>> findAllCustomerId(int id){
		Customer customer = customerDao.findById(id);
		if(customer != null) {
			List<Work> list = dao.findAllCustomerId(id);
			ResponseStruture<List<Work>> struture = new ResponseStruture<List<Work>>();
			struture.setData(list);
			struture.setMessage("All The Works Related To Customer Are Displayed Below...");
			struture.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStruture<List<Work>>>(struture,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundByCustomerIdException("Please Enter The Valid Customer Id...");
	}

}
