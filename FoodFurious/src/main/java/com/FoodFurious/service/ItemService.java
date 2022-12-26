package com.FoodFurious.service;

import java.util.*;

import com.FoodFurious.exceptions.ItemException;
import com.FoodFurious.models.*;

public interface ItemService {

	public Item addItems(Item item);

	public List<Item> getAllItem();

	public Item viewItem(Integer itemId) throws ItemException;

	public Item updateitem(Item item) throws ItemException;

	public Item removeItem(Integer itemId) throws ItemException;

	public Item getItemByName(String Iname);
}
