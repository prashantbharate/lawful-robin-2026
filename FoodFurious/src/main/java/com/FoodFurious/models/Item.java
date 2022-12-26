package com.FoodFurious.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ItemId;

	@NotBlank
	@NotBlank
	@NotBlank
	@Size(min = 2, max = 30, message = "Item name should be between 3 to 30 character.")
	private String ItemName;

	@OneToOne(cascade = CascadeType.ALL)
	private Category category;

	private Integer Quantity;

	private Integer Cost;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Restaurant> restuarant = new ArrayList<>();
}
