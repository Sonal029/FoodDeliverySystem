package com.food.service;

import org.springframework.stereotype.Service;

import com.food.model.DeliveryPartner;

@Service
public interface DeliveryPartnerService {

	public DeliveryPartner addDeliveryPartner(DeliveryPartner dp);
}
