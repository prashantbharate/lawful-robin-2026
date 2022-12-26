package com.FoodFurious.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer BillId;
	private LocalDate BillDate;
	private Integer TotalItem;
	private Double TotalCost;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails orderDetails;

}
