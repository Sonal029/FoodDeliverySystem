package com.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.food.exception.DeliveryException;
import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.Order.OrderStatus;

@Service
public interface OrderService {

	 public Order placeOrder(Order order) throws DeliveryException;
	 public void updateOrderStatus(Integer orderId, OrderStatus newStatus) throws DeliveryException;
	 public List<Order> getCustomerOrderHistory(Integer customerId) throws DeliveryException;
	 public void assignDeliveryPartner(Integer orderId, Integer deliveryPartnerId) throws DeliveryException ;

}
