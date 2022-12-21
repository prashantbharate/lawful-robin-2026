package com.FoodFurious.service;

import java.time.LocalDate;
import java.util.List;

import com.FoodFurious.models.Bill;

public interface BillService {
	public Bill addBill(Bill bill);

	public Bill updateBill(Bill bill);

	public Bill removeBill(Integer billId);

	public Bill viewBill(Integer billId);

	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate);

	public List<Bill> viewBills(String custid);

	public Double calculateTotalCost(Bill bill);

}
