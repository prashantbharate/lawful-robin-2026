package com.FoodFurious.service;

import com.FoodFurious.exceptions.RestaurantException;
import com.FoodFurious.models.Restaurant;

public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant restaurant);

	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException;

	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException;

}
