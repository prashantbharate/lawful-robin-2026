package com.FoodFurious.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CatId;
	
	@NotNull
	@NotBlank
	@NotNull
	@Size(min = 2,max = 20,message = "First name should be between 2s to 30 character.")
	private String CatName;
	
}
