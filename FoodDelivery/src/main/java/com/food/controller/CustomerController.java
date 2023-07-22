package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.Customer;
import com.food.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeNote()
	{
		return new ResponseEntity<>("welcome",HttpStatus.OK);
	}
	@PostMapping("/customers/{customer}")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<>(cs.addCustomer(customer),HttpStatus.CREATED);
	}
}
