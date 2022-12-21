package com.FoodFurious.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.CustomerException;
import com.FoodFurious.models.CurrentCustomerSession;
import com.FoodFurious.models.Customer;
import com.FoodFurious.models.CustomerSigninDTO;
import com.FoodFurious.repository.CustomerDao;
import com.FoodFurious.repository.CustomerSessionDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao CustomerDao;

	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;

	@Override
	public Customer createCustomer(CustomerSigninDTO customersigninDto) throws CustomerException {
		Optional<Customer> opt = CustomerDao.findByMobile(customersigninDto.getMobile());

		if (opt.isPresent()) {
			throw new CustomerException("User already exist");
		}

		Customer customer = new Customer();
		customer.setCustomerName(customersigninDto.getCustomerName());
		customer.setPassword(customersigninDto.getPassword());
		customer.setMobile(customersigninDto.getMobile());
		customer.setEmail(customersigninDto.getEmail());
		customer.setAddress(customersigninDto.getAddress());

		// add type
		customer.setUserType("customer");

		if (opt.isPresent()) {
			System.out.println("User already exist");
		}
		return CustomerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(CustomerSigninDTO customersigninDto, String key) {
		Optional<CurrentCustomerSession> optCurrcustomer = CustomerSessionDAO.findByUuid(key);
		Customer customer = new Customer();
		customer.setCustomerName(customersigninDto.getCustomerName());
		customer.setPassword(customersigninDto.getPassword());
		customer.setMobile(customersigninDto.getMobile());
		customer.setEmail(customersigninDto.getEmail());
		customer.setAddress(customersigninDto.getAddress());

		customer.setUserType("customer");
		if (!optCurrcustomer.isPresent()) {

			throw new RuntimeException("Unauthorised access");
		}

		return CustomerDao.save(customer);
	}

	@Override
	public Customer updateUser(Customer customer, String key) {
		Optional<CurrentCustomerSession> optCurrcustomer = CustomerSessionDAO.findByUuid(key);

		if (!optCurrcustomer.isPresent()) {

			throw new RuntimeException("Unauthorised access");
		}

		return CustomerDao.save(customer);
	}

	@Override
	public List<Customer> allCustomer() {
		return CustomerDao.findAll();
	}

}
