package com.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Customer;
import com.food.model.DeliveryPartner;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Integer>{

	Optional<DeliveryPartner> findById(Integer deliveryPartnerId);

}
