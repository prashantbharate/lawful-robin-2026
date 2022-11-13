package com.FoodFurious.service;

import com.FoodFurious.exceptions.CustomerException;
import com.FoodFurious.models.Admin;
import com.FoodFurious.models.AdminSigninDTO;
import com.FoodFurious.models.Customer;

public interface AdminService {
	public Admin createAdmin(AdminSigninDTO adminsiginDto);
	public Admin updateAdmin(AdminSigninDTO adminsiginDTO, String key);
	public Customer removeCustomer(Customer customer,String key) throws CustomerException;
}

