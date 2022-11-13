


package com.FoodFurious.controllers;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.exceptions.CustomerException;
import com.FoodFurious.models.Customer;
import com.FoodFurious.models.CustomerSigninDTO;
import com.FoodFurious.service.CustomerLoginService;
import com.FoodFurious.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired CustomerService customerService;
	
	@Autowired CustomerLoginService customerLoginService;
	
	

//  Fmethod
//	@PostMapping("/")
//	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customer){
//		return new ResponseEntity<Customer>(customerService.createCustomer(customer),HttpStatus.OK);
//	}
	
	@PostMapping("/")
	public Customer saveCustomer(@Valid @RequestBody CustomerSigninDTO customer) throws CustomerException {
		return customerService.createCustomer(customer);
	}

	// to update customer by passing key
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerSigninDTO customer, @RequestParam(required = false) String key) throws LoginException {
		customerLoginService.isLoggedInByUUID(key);
		return customerService.updateCustomer(customer, key);
	}

	


}

