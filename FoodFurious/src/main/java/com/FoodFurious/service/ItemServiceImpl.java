package com.FoodFurious.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.models.Item;
import com.FoodFurious.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository ir;

	//@Autowired
	//private RestaurantRepo restaurantRepo;
	
	//@Autowired
	//private CategoryRepo categoryRepo;
	
	
	
	@Override
	public Item AddItems(Item item, Integer RestaurantId, Integer CatId) {
		// TODO Auto-generated method stub
		
		
		
		//System.out.println(RestaurantId);
	//	Optional<Restaurant> opt = restaurantRepo.findById(restroId);
		
	/*	if(opt.isPresent()) {
			
			Optional<Category> opt2 = categoryRepo.findById(cateId);
			if(opt2.isPresent()) {
			
				Item itm = ir.save(item);
				                              
				Category cat = opt2.get();
				cat.getItem_list().add(itm);
				categoryRepo.save(cat);
				
				Restaurant rest = opt.get();
				rest.getItem_list().add(itm);
				restaurantRepo.save(rest);
				return itm;
			}
			else {
				throw new StudentException("CategoryId invalid");
			}
			
//			return item;
			
		}else {
			throw new StudentException("Invalid restraunt  Id");
		}
		return null;
	

	*/
		return null;
	}
	
	
	
	@Override
	public List<Item> getAllItem() {
		// TODO Auto-generated method stub
		
		
		List<Item> lst  = ir.findAll();
		if(lst.size() > 0) {
			return lst;
		}
		else {
			//throw new ItemException("Record not found");
		}
		return null;
		
		
	}



	@Override
	public Item updateitem(Item item) {
		// TODO Auto-generated method stub
		
		Optional<Item> it= ir.findById(item.getItemId());
		
		if(it.isPresent())
		{
			Item i=ir.save(item);
			return i;
		}
		else
		{
			return null;
		}
		
	}



	@Override
	public Item removeItem(Item item) {
		// TODO Auto-generated method stub
		
		Optional<Item> it=ir.findById(item.getItemId());
		
		if(it.isPresent())
		{
			 ir.delete(it.get());
			 return item;
			
			
		}
		else
		{
		return null;
		}
	}



	@Override
	public Item getItemByName(String Iname) {
		// TODO Auto-generated method stub
		
		Optional<Item> it= ir.findByName(Iname);
		if(it.isPresent())
		{
			Item i= it.get();
		}
		
		
		return null;
		
	}
	
	


	
	

}
