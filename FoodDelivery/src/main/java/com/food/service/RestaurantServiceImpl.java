package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.Restaurant;
import com.food.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant)
	{
		return restaurantRepo.save(restaurant);
	}
}
