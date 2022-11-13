package com.FoodFurious.controllers;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.models.Admin;
import com.FoodFurious.models.AdminSigninDTO;
import com.FoodFurious.service.AdminLoginService;
import com.FoodFurious.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired AdminService adminService;
	@Autowired AdminLoginService adminLoginService;
	
	
	@PostMapping("/")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody AdminSigninDTO admin) {
		return new ResponseEntity<Admin>(adminService.createAdmin(admin),HttpStatus.OK);
	}
	

	// to update admin by passing key	
	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody AdminSigninDTO admin, @RequestParam(required = false) String key) throws LoginException {
		adminLoginService.isLoggedInByUUID(key);
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, key),HttpStatus.OK);
	}
	
	
	
	
	
}
