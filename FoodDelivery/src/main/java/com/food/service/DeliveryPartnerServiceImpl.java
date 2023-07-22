package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.DeliveryPartner;
import com.food.repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {

	@Autowired
	private DeliveryPartnerRepository deliveryPartnerRepo;
	
	
	@Override
	public DeliveryPartner addDeliveryPartner(DeliveryPartner dp) {
		// TODO Auto-generated method stub
		return deliveryPartnerRepo.save(dp);
	}

	
}
