package com.FoodFurious.models;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer resturantId;

	@NotBlank
	@NotNull
	private String resturantName;

	private String managerName;

	@Size(min = 10, max = 10, message = "contactNumber should be of 10 number length")
	private String contactNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>();

}
