package com.FoodFurious.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer BillId;
	private LocalDate BillDate;
	private Integer TotalItem;
	private Double TotalCost;
	
	@OneToOne (cascade = CascadeType.ALL)
	private OrderDetails orderDetails;
	
	
	
	public Bill() {
		// TODO Auto-generated constructor stub
		this.BillDate=LocalDate.now();
	}



	public Bill(Integer billId, LocalDate billDate, Integer totalItem, Double totalCost,
			OrderDetails orderDetails) {
		super();
		BillId = billId;
		BillDate = billDate;
		TotalItem = totalItem;
		TotalCost = totalCost;
		this.orderDetails = orderDetails;
	}



	public Integer getBillId() {
		return BillId;
	}



	public void setBillId(Integer billId) {
		BillId = billId;
	}



	public LocalDate getBillDate() {
		return BillDate;
	}



	public void setBillDate(LocalDate billDate) {
		BillDate = billDate;
	}



	public Integer getTotalItem() {
		return TotalItem;
	}



	public void setTotalItem(Integer totalItem) {
		TotalItem = totalItem;
	}



	public Double getTotalCost() {
		return TotalCost;
	}



	public void setTotalCost(Double totalCost) {
		TotalCost = totalCost;
	}



	public OrderDetails getOrderDetails() {
		return orderDetails;
	}



	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
	

}
