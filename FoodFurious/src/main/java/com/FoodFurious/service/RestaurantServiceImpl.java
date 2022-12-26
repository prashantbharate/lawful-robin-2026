package com.FoodFurious.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.RestaurantException;
import com.FoodFurious.models.Restaurant;
import com.FoodFurious.repository.RestaurantDAO;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurantDAO.save(restaurant);
		return restaurant;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
		restaurantDAO.findById(restaurant.getResturantId())
				.orElseThrow(() -> new RestaurantException("no restaurant found..."));
		Restaurant updateRestaurant = restaurantDAO.save(restaurant);
		return updateRestaurant;
	}

	@Override
	public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
		Restaurant removeRestaurant = restaurantDAO.findById(restaurantId)
				.orElseThrow(() -> new RestaurantException("no restaurant found..."));
		restaurantDAO.deleteById(restaurantId);
		return removeRestaurant;
	}

}
