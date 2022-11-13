package com.FoodFurious.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.models.Category;
import com.FoodFurious.repository.CatRepository;

@Service
public class CatServiceImpl implements CatService{

//	
	@Autowired
	private CatRepository cr;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		
		Category ct=cr.save(category);
		
		
		return null;
	}

	
	
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> ct= cr.findAll();
		
		return ct;
	}




	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		Optional<Category> ct=cr.findById(category.getCatId());
		
		if(ct.isPresent())
		{
			Category c=cr.save(ct.get());
		}
		
			return null;
	}




	@Override
	public Category deleteCategory(Category category) {
		// TODO Auto-generated method stub
		Optional<Category> ct= cr.findById(category.getCatId());
		
		if(ct.isPresent())
		{
		      cr.delete(category);
		}
		
		return null;
	}




	
	
}
