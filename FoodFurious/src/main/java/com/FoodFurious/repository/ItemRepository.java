package com.FoodFurious.repository;

import java.util.List;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodFurious.models.Item;



@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

	@Query("select t from Item t where t.ItemName=?1")
	public Optional<Item> findByName(String Iname);
	

}
