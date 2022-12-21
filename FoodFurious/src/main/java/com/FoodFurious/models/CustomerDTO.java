package com.FoodFurious.models;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerDTO {
	@NotNull(message = "Mobile is mandatory")
	private String mobile;

	@NotNull(message = "Password is mandatory")
	private String password;

	private String customerName;
	private String email;
	private String address;

}
