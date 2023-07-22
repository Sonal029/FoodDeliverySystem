package com.food.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Customer;
import com.food.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	Optional<Order> findById(Integer orderId);

	    List<Order> findByCustomerCustomerId(Integer customerId);

}
