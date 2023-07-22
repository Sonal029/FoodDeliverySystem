package com.food.service;

import org.springframework.stereotype.Service;

import com.food.model.Customer;

@Service
public interface CustomerService {

	
	public Customer addCustomer(Customer customer); 
}
