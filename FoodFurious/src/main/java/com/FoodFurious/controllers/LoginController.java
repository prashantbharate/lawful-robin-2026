<<<<<<< HEAD
package com.FoodFurious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.models.AdminDTO;
import com.FoodFurious.models.CustomerDTO;
import com.FoodFurious.service.AdminLogInServiceImpl;
import com.FoodFurious.service.CustomerLoginServiceImpl;

@RestController

@RequestMapping("/login")
public class LoginController {
	@Autowired
	private CustomerLoginServiceImpl customerLoginServiceImpl;

	@Autowired
	private AdminLogInServiceImpl adminLogInServiceImpl;

	// for user login
	@PostMapping("/userlogin")
	public String loginCustomerr(@RequestBody CustomerDTO customerDTO) throws Exception {
		return customerLoginServiceImpl.logIntoAccount(customerDTO);
	}

	// for user logout
	@PatchMapping("/userlogout")
	public String logOutCustomerr(@RequestParam(required = false) String key) {
		return customerLoginServiceImpl.logOutAccount(key);
	}

	// for admin login
	@PostMapping("/adminlogin")
	public String logInAdmin(@RequestBody AdminDTO adminDTO) {
		return adminLogInServiceImpl.logIntoAccount(adminDTO);
	}

	// for admin logout
	@PatchMapping("/adminlogout")
	public String logOutAdmin(@RequestParam(required = false) String key) {
		return adminLogInServiceImpl.logOutAccount(key);
	}
}
=======
package com.FoodFurious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.models.AdminDTO;
import com.FoodFurious.models.CustomerDTO;
import com.FoodFurious.service.AdminLogInServiceImpl;
import com.FoodFurious.service.CustomerLoginServiceImpl;

@RestController

@RequestMapping("/login")
public class LoginController {
	@Autowired
	private CustomerLoginServiceImpl customerLoginServiceImpl;

	@Autowired
	private AdminLogInServiceImpl adminLogInServiceImpl;

	// for user login
	@PostMapping("/userlogin")
	public String loginCustomerr(@RequestBody CustomerDTO customerDTO) throws Exception {
		return customerLoginServiceImpl.logIntoAccount(customerDTO);
	}

	// for user logout
	@PatchMapping("/userlogout")
	public String logOutCustomerr(@RequestParam(required = false) String key) {
		return customerLoginServiceImpl.logOutAccount(key);
	}

	// for admin login
	@PostMapping("/adminlogin")
	public String logInAdmin(@RequestBody AdminDTO adminDTO) {
		return adminLogInServiceImpl.logIntoAccount(adminDTO);
	}

	// for admin logout
	@PatchMapping("/adminlogout")
	public String logOutAdmin(@RequestParam(required = false) String key) {
		return adminLogInServiceImpl.logOutAccount(key);
	}
}
>>>>>>> main
