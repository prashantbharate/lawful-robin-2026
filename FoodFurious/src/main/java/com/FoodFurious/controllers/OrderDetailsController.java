package com.FoodFurious.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.FoodFurious.exceptions.orderException;
import com.FoodFurious.models.OrderDetails;
import com.FoodFurious.repository.OrderDetailsRepo;
import com.FoodFurious.service.OrderService;

public class OrderDetailsController {

	private OrderService orderService;

	@PostMapping("/Orders")
	public ResponseEntity<OrderDetails> CreateOrder(@Valid @RequestBody OrderDetails order) {

		OrderDetails newOrder = orderService.addOrderDetails(order);

		return new ResponseEntity<OrderDetails>(newOrder, HttpStatus.CREATED);
	}

	@DeleteMapping("/Orders/{id}")
	public ResponseEntity<OrderDetails> DeleteOrder(@PathVariable("id") Integer orderid) throws orderException {

		OrderDetails order = orderService.removeOrderDetails(orderid);

		return new ResponseEntity<OrderDetails>(order, HttpStatus.OK);
	}

	@PutMapping("/Orders")
	public ResponseEntity<OrderDetails> Update(@RequestBody OrderDetails Order) throws orderException {

		OrderDetails updatedorder = orderService.updateOrderDetails(Order);

		return new ResponseEntity<OrderDetails>(updatedorder, HttpStatus.ACCEPTED);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId) throws orderException {

		OrderDetails order = orderService.viewOrderDetails(orderId);
		return new ResponseEntity<OrderDetails>(order, HttpStatus.OK);
	}

}
