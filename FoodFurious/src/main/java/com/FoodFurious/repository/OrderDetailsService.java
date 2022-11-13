package com.FoodFurious.service;

import java.util.List;

import com.FoodFurious.exceptions.orderException;
import com.FoodFurious.models.Customer;
import com.FoodFurious.models.OrderDetails;
//import com.Food.Model.Resturant;

public interface OrderDetailsService {
	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails removeOrder(Integer orderId )throws orderException;
	public OrderDetails  updateOrder(OrderDetails order)throws orderException;
	public OrderDetails viewOrder(Integer orderId)throws orderException;
//	public List<OrderDetails> ViewAllOrders(Resturant res)throws orderException;
//	public List<OrderDetails> ViewAllOrders(String customerId)throws orderException;

}
