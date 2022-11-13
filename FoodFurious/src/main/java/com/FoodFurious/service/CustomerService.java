package com.FoodFurious.service;

import java.util.List;

import com.FoodFurious.exceptions.CustomerException;
import com.FoodFurious.models.Customer;
import com.FoodFurious.models.CustomerSigninDTO;



public interface CustomerService {
//	Fmethod	
//	public Customer createCustomer(CustomerDTO customer);
	
	public Customer createCustomer(CustomerSigninDTO customersigninDto) throws CustomerException;
	
	
	public Customer updateUser(Customer customer, String key);
	
	public Customer updateCustomer(CustomerSigninDTO customersigninDto, String key);
	
	
	public List<Customer> allCustomer();

}
