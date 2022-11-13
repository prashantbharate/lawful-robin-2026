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

import java.util.*;
import com.FoodFurious.service.CatService;
import com.FoodFurious.models.Category;
@RestController
public class CategoryController {

	
	
	@Autowired
	private CatService cs;
	
	@PostMapping("/category/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		Category cate = cs.addCategory(category);
		return new ResponseEntity<Category>(cate, HttpStatus.CREATED);
	}
	
	@GetMapping("/category/allcategory")
	public ResponseEntity<List<Category>> listCategory(){
		
		List<Category> ct=cs.getAllCategory();
		return new ResponseEntity<List<Category>>(ct, HttpStatus.CREATED);
	}
	
	@PutMapping("/category/update")
	public ResponseEntity<Category> updateItem(@RequestBody Category category)
	{
		
		return new  ResponseEntity<Category>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("category/delete/{Catid}")
	public ResponseEntity<Category> deleteItem(@RequestParam("Catid") Integer Catid)
	{
		
		return new ResponseEntity<Category>(HttpStatus.CREATED);
	}
}

