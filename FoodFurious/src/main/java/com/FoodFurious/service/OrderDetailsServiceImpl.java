package com.FoodFurious.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.orderException;
import com.FoodFurious.models.Customer;
import com.FoodFurious.models.OrderDetails;
//import com.FoodFurious.models.Resturant;
import com.FoodFurious.repository.OrderDetailsRepo;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private OrderDetailsRepo oRepo;
	
	
	
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		OrderDetails n=oRepo.save(order);	
		return n;
	}

	@Override
	public OrderDetails removeOrder(Integer orderId) throws orderException{
		
		
		Optional<OrderDetails> opt= oRepo.findById(orderId);
		
		if(opt.isPresent()) {
			OrderDetails ExistingOrder=opt.get();
			oRepo.delete(ExistingOrder);
			return ExistingOrder;
		}
		else throw new orderException();
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order)throws orderException {
		Optional<OrderDetails> opt=oRepo.findById(order.getOrderId());
		
		if(opt.isPresent()) {
			OrderDetails SavedOrder=oRepo.save(order);
					return SavedOrder;
		}
		else
			throw new orderException("Bill Not Found");
		
		
	}

	@Override
	public OrderDetails viewOrder(Integer id)throws orderException {
		Optional<OrderDetails> opt=oRepo.findById(id);
		if(opt.isPresent()) {
			OrderDetails order=opt.get();
			return order;
		}
		else throw new orderException("No order found with this order id"+id);
	}

//	@Override
//	public List<OrderDetails> ViewAllOrders(Resturant res) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<OrderDetails> ViewAllOrders(String  customerId)throws orderException {
//		
//		return null;
//	}

}
