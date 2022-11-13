package com.FoodFurious.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.FoodFurious.models.Item;
import com.FoodFurious.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService is1;
	
	
	//here we are Saving the Order and category of Order And with Restaurents
	
	@PostMapping("/additem/{RestaurantId}/{CatId}")
	public ResponseEntity<Item> AddItemToRestaurent(@RequestBody Item item, @PathVariable("RestaurantId") Integer RestaurantId,@PathVariable("CatId") Integer CatId)
	{
		Item it= is1.AddItems(item, RestaurantId, CatId);
		return new ResponseEntity<Item>(it,HttpStatus.CREATED);
	}
	
	
	//Here We Are Getting All The List 
	
	@GetMapping("/Allitems")
	public  ResponseEntity<List<Item>> getAllItems(){
		List<Item> iss= is1.getAllItem();
		return new ResponseEntity<List<Item>>(iss,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/Updateitem")
	public ResponseEntity<Item> updateItem(@RequestBody Item item)
	{
		Item i2=is1.updateitem(item);
		return new ResponseEntity<Item>(i2,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/Delteitem")
	public ResponseEntity<Item> deleteItem(@RequestBody Item item)
	{
		Item i3=is1.removeItem(item);
		return new ResponseEntity<Item>(i3,HttpStatus.CREATED);
	}
	
	@GetMapping("/Allitems/{iname}")
	public ResponseEntity<Item> getItemByName(@PathVariable("iname") String iname )
	{
		Item i4=is1.getItemByName(iname);
		return new ResponseEntity<Item>(i4,HttpStatus.CREATED);
	}
	
	
}
