package com.FoodFurious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FoodFurious.exceptions.ItemException;
import com.FoodFurious.models.Item;
import com.FoodFurious.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("items/additem")
	public ResponseEntity<Item> addItemHandler(@RequestBody Item item) {
		Item savedItem = itemService.addItems(item);
		return new ResponseEntity<Item>(savedItem, HttpStatus.CREATED);

	}

	@PutMapping("items/updateitem")
	public ResponseEntity<Item> updateItemHandler(@RequestBody Item item) throws ItemException {
		Item savedItem = itemService.updateitem(item);
		return new ResponseEntity<Item>(savedItem, HttpStatus.CREATED);

	}

	@GetMapping("items/viewitem")
	public ResponseEntity<Item> updateItemHandler(@RequestParam(required = false) Integer itemId) throws ItemException {
		Item existingItem = itemService.viewItem(itemId);
		return new ResponseEntity<Item>(existingItem, HttpStatus.CREATED);

	}

	@DeleteMapping("items/deleteitem")
	public ResponseEntity<Item> deleteItemHandler(@RequestParam(required = false) Integer itemId) throws ItemException {
		Item removItem = itemService.removeItem(itemId);
		return new ResponseEntity<Item>(removItem, HttpStatus.CREATED);

	}

}
