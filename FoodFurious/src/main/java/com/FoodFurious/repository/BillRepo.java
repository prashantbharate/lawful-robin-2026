package com.FoodFurious.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FoodFurious.models.Bill;


@Repository
public interface BillRepo extends JpaRepository<Bill, Integer>{
	
	@Query ("Select D from Bill D Where D.BillDate BETWEEN $1 AND $2")
	public List<Bill> findByDate(LocalDate sDate,LocalDate eDate);

}
