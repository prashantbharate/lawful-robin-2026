package com.FoodFurious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.exceptions.FoodCartException;
import com.FoodFurious.exceptions.ItemException;
import com.FoodFurious.exceptions.UserException;
import com.FoodFurious.models.FoodCart;
import com.FoodFurious.models.Item;
import com.FoodFurious.service.FoodCartService;

@RestController
public class FoodCartController {

	@Autowired
	private FoodCartService foodCartService;

	@PostMapping("foodcart/additem")
	public ResponseEntity<FoodCart> addItemToCartHandler(@RequestBody Item item,
			@RequestParam(required = false) String key, @RequestParam(required = false) Integer foodCartId)
			throws UserException, FoodCartException {

		FoodCart existingFoodCart = foodCartService.addItemToFoodCart(foodCartId, item, key);
		return new ResponseEntity<FoodCart>(existingFoodCart, HttpStatus.ACCEPTED);
	}

	@PostMapping("/foodcart/increasequantity")
	public ResponseEntity<FoodCart> increaseQunatityHandler(@RequestParam(required = false) Integer foodCartId,
			@RequestParam(required = false) Integer itemId, @RequestParam(required = false) Integer quantity,
			@RequestParam(required = false) String key) throws UserException, FoodCartException {

		FoodCart existingFoodCart = foodCartService.increaseQuantity(foodCartId, itemId, quantity, key);

		return new ResponseEntity<FoodCart>(existingFoodCart, HttpStatus.ACCEPTED);

	}

	@PostMapping("/foodcart/reducequantity")
	public ResponseEntity<FoodCart> reduceQunatityHandler(@RequestParam(required = false) Integer foodCartId,
			@RequestParam(required = false) Integer itemId, @RequestParam(required = false) Integer quantity,
			@RequestParam(required = false) String key) throws UserException, FoodCartException {

		FoodCart existingFoodCart = foodCartService.reduceQuantity(foodCartId, itemId, quantity, key);

		return new ResponseEntity<FoodCart>(existingFoodCart, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/foodcart/removeitem")
	public ResponseEntity<FoodCart> reduceQunatityHandler(@RequestParam(required = false) Integer foodCartId,
			@RequestParam(required = false) Integer itemId, @RequestParam(required = false) String key)
			throws UserException, FoodCartException, ItemException {

		FoodCart existingFoodCart = foodCartService.removeItem(foodCartId, itemId, key);

		return new ResponseEntity<FoodCart>(existingFoodCart, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/foodcart/clearcart")
	public ResponseEntity<FoodCart> clearCartHandler(@RequestParam(required = false) Integer foodCartId,
			@RequestParam(required = false) String key) throws UserException, FoodCartException {

		FoodCart existingFoodCart = foodCartService.clearCart(foodCartId, key);

		return new ResponseEntity<FoodCart>(existingFoodCart, HttpStatus.ACCEPTED);

	}

}
