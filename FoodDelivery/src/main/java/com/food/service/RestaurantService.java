package com.food.service;

import org.springframework.stereotype.Service;

import com.food.model.Restaurant;

@Service
public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restaurant);
}
