package com.FoodFurious.service;
import java.util.*;

import com.FoodFurious.models.*;

public interface ItemService {

	
	public Item AddItems(Item item, Integer RestaurantId, Integer CatId);
	
	public List<Item> getAllItem();
	
	public Item updateitem(Item item);
	
	public Item removeItem(Item item);
	
	public Item getItemByName(String Iname);
}
