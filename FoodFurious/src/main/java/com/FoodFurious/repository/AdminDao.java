package com.FoodFurious.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodFurious.models.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Optional<Admin> findByMobile(String string);
}
