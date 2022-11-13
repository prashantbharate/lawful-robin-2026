package com.FoodFurious.repository;
import com.FoodFurious.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatRepository extends JpaRepository<Category , Integer> {
	

}
