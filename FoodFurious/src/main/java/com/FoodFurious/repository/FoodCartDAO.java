package com.FoodFurious.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodFurious.models.FoodCart;

public interface FoodCartDAO extends JpaRepository<FoodCart, Integer> {

}
