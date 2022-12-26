package com.FoodFurious.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodFurious.models.Item;

public interface ItemDAO extends JpaRepository<Item, Integer> {

}
