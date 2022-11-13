package com.FoodFurious.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Integer userId;
	private String userType;
	private String password;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Booking> bookingList = new ArrayList<>();
//	
//	@OneToMany(cascade =  CascadeType.ALL)
//	private List<Route> routeList = new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Travels> travelsList= new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	List<Bus> busList = new ArrayList<>();
	
}
