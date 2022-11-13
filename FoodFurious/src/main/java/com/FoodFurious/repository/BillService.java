package com.FoodFurious.service;

import java.time.LocalDate;
import java.util.List;

import com.FoodFurious.exceptions.BillException;
import com.FoodFurious.models.Bill;

public interface BillService {
	
	public Bill addBill(Bill bill);
	public Bill update(Bill bill)throws BillException;
	public Bill viewBill(Integer billId)throws BillException; 
	public Bill remove(Integer billId)throws BillException;
	public List<Bill> viewBills(String startDate, String endDate)throws BillException;
	//public List<Bill> viewBills(Integer custId)throws BillException;
	//public Double TotalCost(Bill bill);
}
