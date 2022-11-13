package com.FoodFurious.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodFurious.models.FoodCart;

public interface FoodCartDao extends JpaRepository<FoodCart, Integer> {

	
	
}
