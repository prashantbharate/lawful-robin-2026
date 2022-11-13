package com.FoodFurious.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer OrderId;
	private LocalDate OrderDate;
//	private FoodCart foodCart;
	private String OrderStatus;
	
	

	public Integer getOrderId() {
		return OrderId;
	}



	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}



	public LocalDate getOrderDate() {
		return OrderDate;
	}



	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}



	public String getOrderStatus() {
		return OrderStatus;
	}



	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}


//
	public OrderDetails(Integer orderId, LocalDate orderDate, String orderStatus) {
		super();
		OrderId = orderId;
		OrderDate = orderDate;
		OrderStatus = orderStatus;
	}



	public OrderDetails() {
		super();
		this.OrderDate=LocalDate.now();
	}
	
	
	
	
}
