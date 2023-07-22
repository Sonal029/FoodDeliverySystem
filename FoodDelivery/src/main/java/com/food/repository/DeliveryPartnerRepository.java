package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.DeliveryPartner;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Integer>{

}
