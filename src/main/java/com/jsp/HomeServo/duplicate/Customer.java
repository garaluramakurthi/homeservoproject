package com.jsp.HomeServo.duplicate;

import java.util.List;

import com.jsp.HomeServo.dto.Address;
import com.jsp.HomeServo.dto.Work;

import lombok.Data;

@Data
public class Customer {
	private int id;
	private String name;
	private String email;
	private long phone;
	private int familyCount;
	private Address address;
	private List<Work>works;
}
