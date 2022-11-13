package com.FoodFurious.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodFurious.models.Customer;


public interface CustomerDao extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByMobile(String string);
}
