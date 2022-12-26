package com.FoodFurious.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodFurious.models.Restaurant;

public interface RestaurantDAO extends JpaRepository<Restaurant, Integer> {

}
