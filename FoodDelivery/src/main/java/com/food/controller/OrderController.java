package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.exception.DeliveryException;
import com.food.model.Order;
import com.food.model.Order.OrderStatus;
import com.food.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws DeliveryException {
        Order placedOrder = orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(placedOrder);
    }

    @PutMapping("/{orderId}/assign/{deliveryPartnerId}")
    public ResponseEntity<String> assignDeliveryPartner(@PathVariable Integer orderId, @PathVariable Integer deliveryPartnerId) throws DeliveryException {
        orderService.assignDeliveryPartner(orderId, deliveryPartnerId);
        return ResponseEntity.ok("Order assigned to Delivery Partner successfully.");
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Integer orderId, @RequestParam OrderStatus newStatus) throws DeliveryException {
        orderService.updateOrderStatus(orderId, newStatus);
        return ResponseEntity.ok("Order status updated successfully.");
    }
    
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrderHistory(@PathVariable Integer customerId) throws DeliveryException {
        List<Order> orderHistory = orderService.getCustomerOrderHistory(customerId);
        return ResponseEntity.ok(orderHistory);
    }


}

