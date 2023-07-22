package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
