package com.FoodFurious.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.FoodFurious.models.Bill;

import io.swagger.v3.oas.annotations.servers.Server;


public class BillServiceImpl implements BillService {

	@Override
	public Bill addBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill removeBill(Integer billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill viewBill(Integer billId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBills(String custid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateTotalCost(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

}
