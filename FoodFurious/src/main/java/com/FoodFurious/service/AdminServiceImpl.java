package com.FoodFurious.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.CustomerException;
import com.FoodFurious.models.Admin;
import com.FoodFurious.models.AdminSigninDTO;
import com.FoodFurious.models.CurrentAdminSession;
import com.FoodFurious.models.Customer;
import com.FoodFurious.repository.AdminDao;
import com.FoodFurious.repository.AdminSessionDAO;
import com.FoodFurious.repository.CustomerDao;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminSessionDAO adminSessionDAO;
	
	
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public Admin createAdmin(AdminSigninDTO adminsigninDto) {
		Optional<Admin> opt = adminDao.findByMobile(adminsigninDto.getMobile());
		Admin admin = new Admin();
		admin.setAdminName(adminsigninDto.getAdminName());
		admin.setPassword(adminsigninDto.getPassword());
		admin.setMobile(adminsigninDto.getMobile());
		admin.setEmail(adminsigninDto.getEmail());

		admin.setUserType("admin");

		if (opt.isPresent()) {
			System.out.println("User already exist");
		}
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(AdminSigninDTO adminsigninDto, String key) {
		Optional<CurrentAdminSession> optCurrAdmin = adminSessionDAO.findByUuid(key);
		Admin admin = new Admin();
		admin.setAdminName(adminsigninDto.getAdminName());
		admin.setPassword(adminsigninDto.getPassword());
		admin.setMobile(adminsigninDto.getMobile());
		admin.setEmail(adminsigninDto.getEmail());

		admin.setUserType("admin");
		if (!optCurrAdmin.isPresent()) {

			throw new RuntimeException("Unauthorised access");
		}

		return adminDao.save(admin);
	}

	@Override
	public Customer removeCustomer(Customer customer, String key) throws CustomerException {
		// TODO Auto-generated method stub

		Optional<CurrentAdminSession> currenAdminOpt = adminSessionDAO.findByUuid(key);
		
		if(currenAdminOpt.isPresent()) {
			
			Optional<Customer> existingCustomer = customerDao.findById(customer.getCustomerId());
			if(existingCustomer.isPresent()) {
				 customerDao.deleteById(customer.getCustomerId());
				 return customer;
			}
			
			throw new CustomerException("customer id is invalid..");
			
		}

		throw new CustomerException("login first ");
	}
}
