package com.FoodFurious.service;

import java.util.List;

import com.FoodFurious.models.OrderDetails;

public interface OrderService {
	public OrderDetails addOrderDetails(OrderDetails orderDetails);

	public OrderDetails updateOrderDetails(OrderDetails orderDetails);

	public OrderDetails removeOrderDetails(Integer orderId);

	public OrderDetails viewOrderDetails(Integer orderId);

	public List<OrderDetails> viewAllOrderDetailsByRestaurant(Integer restaurantId);

	public List<OrderDetails> viewAllOrderDetailsCustomer(Integer customerId);

}
