package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.food.exception.DeliveryException;
import com.food.model.Customer;
import com.food.model.DeliveryPartner;
import com.food.model.Order;
import com.food.model.Order.OrderStatus;
import com.food.model.Restaurant;
import com.food.repository.CustomerRepository;
import com.food.repository.DeliveryPartnerRepository;
import com.food.repository.OrderRepository;
import com.food.repository.RestaurantRepository;

@Service
public class OrderServiceImpl implements OrderService{


	    @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private RestaurantRepository restaurantRepository;

	    @Autowired
	    private DeliveryPartnerRepository deliveryPartnerRepository;

	    @Override
	    public Order placeOrder(Order order) throws DeliveryException {
	        // Validate customer and restaurant existence
	        Customer customer = customerRepository.findById(order.getCustomer().getCustomerId())
	                .orElseThrow(() -> new DeliveryException("Customer not found with ID: " + order.getCustomer().getCustomerId()));

	        Restaurant restaurant = restaurantRepository.findById(order.getRestaurant().getRestaurantId())
	                .orElseThrow(() -> new DeliveryException("Restaurant not found with ID: " + order.getRestaurant().getRestaurantId()));

	        // Additional validation or business logic for placing an order (if required)

	        order.setCustomer(customer);
	        order.setRestaurant(restaurant);
	        order.setOrderStatus(OrderStatus.PLACED);

	        return orderRepository.save(order);
	    }

	    @Override
	    public void assignDeliveryPartner(Integer orderId, Integer deliveryPartnerId) throws DeliveryException {
	        // Fetch the order and validate its existence
	        Order order = orderRepository.findById(orderId)
	                .orElseThrow(() -> new DeliveryException("Order not found with ID: " + orderId));

	        // Fetch the delivery partner and validate its existence
	        DeliveryPartner deliveryPartner = deliveryPartnerRepository.findById(deliveryPartnerId)
	                .orElseThrow(() -> new DeliveryException("Delivery Partner not found with ID: " + deliveryPartnerId));

	        // Check if the order is already delivered
	        if (order.getOrderStatus() == OrderStatus.DELIVERED) {
	            throw new IllegalStateException("Cannot assign delivery partner to a delivered order.");
	        }

	        // Check if the order is already assigned to another delivery partner
	        if (order.getDeliveryPartner() != null) {
	            throw new IllegalStateException("Order is already assigned to another delivery partner.");
	        }

	        order.setDeliveryPartner(deliveryPartner);
	        order.setOrderStatus(OrderStatus.ASSIGNED);

	        orderRepository.save(order);
	    }

	    @Override
	    public void updateOrderStatus(Integer orderId, OrderStatus newStatus) throws DeliveryException {
	        // Fetch the order and validate its existence
	        Order order = orderRepository.findById(orderId)
	                .orElseThrow(() -> new DeliveryException("Order not found with ID: " + orderId));

	        // Check for invalid status transitions (e.g., from "DELIVERED" back to "COOKING")
	        if (order.getOrderStatus() == OrderStatus.DELIVERED && newStatus != OrderStatus.DELIVERED) {
	            throw new IllegalStateException("Cannot update order status from 'DELIVERED' to another status.");
	        }

	        order.setOrderStatus(newStatus);
	        orderRepository.save(order);
	    }

	    @Override
	    public List<Order> getCustomerOrderHistory(Integer customerId) throws DeliveryException {
	        // Fetch the customer and validate its existence
	        Customer customer = customerRepository.findById(customerId)
	                .orElseThrow(() -> new DeliveryException("Customer not found with ID: " + customerId));

	        return orderRepository.findByCustomerCustomerId(customerId);
	    }

	}
