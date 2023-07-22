package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.Customer;
import com.food.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public Customer addCustomer(Customer customer)
	{
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

}
