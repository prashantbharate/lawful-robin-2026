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
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.exceptions.orderException;
import com.FoodFurious.models.OrderDetails;
import com.FoodFurious.repository.OrderDetailsRepo;
import com.FoodFurious.service.OrderDetailsService;

@RestController
public class OrderDetailsController {
	
	private OrderDetailsService oservice;
	
	@PostMapping("/Orders")
	public ResponseEntity<OrderDetails> CreateOrder(@RequestBody OrderDetails order){
		
	OrderDetails newOrder=	oservice.addOrder(order);
		
	
		return new ResponseEntity<OrderDetails>(newOrder,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Orders/{id}")
	public ResponseEntity<OrderDetails> DeleteOrder(@PathVariable("id") Integer orderid ) throws orderException{
		
		OrderDetails order=oservice.removeOrder(orderid);
		
		return new ResponseEntity<OrderDetails>(order,HttpStatus.OK);
	}
	
	@PutMapping("/Orders")
	public ResponseEntity<OrderDetails> Update(@RequestBody OrderDetails Order) throws orderException{
		
		OrderDetails updatedorder=oservice.updateOrder(Order);
		
		return new ResponseEntity<OrderDetails>(updatedorder,HttpStatus.ACCEPTED);
	}

	@GetMapping("/Bill/{id}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable ("id") Integer Oid) throws orderException{
		
		OrderDetails order=oservice.viewOrder(Oid);
		return new ResponseEntity<OrderDetails>(order,HttpStatus.OK);
	}

}
