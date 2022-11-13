package com.FoodFurious.service;

import com.FoodFurious.models.Category;
import com.FoodFurious.exceptions.CategoryException;
import java.util.*;
public interface CatService {
	
	
		public Category addCategory(Category category);
			
		public List<Category> getAllCategory();
		
		public Category updateCategory(Category category); 
		
		public Category deleteCategory(Category category);

}
