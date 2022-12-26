package com.FoodFurious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.exceptions.RestaurantException;
import com.FoodFurious.models.Restaurant;
import com.FoodFurious.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping("/restaurant/add")
	public ResponseEntity<Restaurant> addRestaurantHandler(@RequestBody Restaurant restaurant) {
		Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(savedRestaurant, HttpStatus.CREATED);
	}

	@PutMapping("/restaurant/add")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@RequestBody Restaurant restaurant)
			throws RestaurantException {
		Restaurant updateRestaurant = restaurantService.updateRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(updateRestaurant, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/restaurant/delete")
	public ResponseEntity<Restaurant> updateRestaurantHandler(@RequestParam(required = false) Integer restaurantId)
			throws RestaurantException {
		Restaurant removeRestaurant = restaurantService.removeRestaurant(restaurantId);
		return new ResponseEntity<Restaurant>(removeRestaurant, HttpStatus.ACCEPTED);
	}
}
