package com.FoodFurious.service;

import javax.security.auth.login.LoginException;

import com.FoodFurious.models.AdminDTO;

public interface AdminLoginService {
	public String logIntoAccount(AdminDTO adminDTO);
	public String logOutAccount(String key);
	public boolean isLoggedIn(Integer adminId) throws LoginException ;
	public boolean isLoggedInByUUID(String uuid) throws LoginException ;
}
