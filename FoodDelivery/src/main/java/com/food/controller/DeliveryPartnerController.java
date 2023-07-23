package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.DeliveryPartner;
import com.food.service.DeliveryPartnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/deliverypartners")
public class DeliveryPartnerController {

	
	@Autowired
	private DeliveryPartnerService dps;
	
	@PostMapping("/deliverypartner/{dp}")
	public ResponseEntity<DeliveryPartner> addDeliveryPartnerHandler(@Valid @RequestBody DeliveryPartner dp)
	{
		return new ResponseEntity<>(dps.addDeliveryPartner(dp),HttpStatus.CREATED);
	}
}
