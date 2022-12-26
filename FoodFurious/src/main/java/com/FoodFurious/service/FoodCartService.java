package com.FoodFurious.service;

import com.FoodFurious.exceptions.FoodCartException;
import com.FoodFurious.exceptions.ItemException;
import com.FoodFurious.exceptions.UserException;
import com.FoodFurious.models.FoodCart;
import com.FoodFurious.models.Item;

public interface FoodCartService {

	public FoodCart addItemToFoodCart(Integer foodCartId, Item item, String key)
			throws UserException, FoodCartException;

	public FoodCart increaseQuantity(Integer foodCartId, Integer itemId, Integer quantity, String key)
			throws UserException, FoodCartException;

	public FoodCart reduceQuantity(Integer foodCartId, Integer itemId, Integer quantity, String key)
			throws UserException, FoodCartException;

	public FoodCart removeItem(Integer foodCartId, Integer itemId, String key)
			throws UserException, FoodCartException, ItemException;

	public FoodCart clearCart(Integer foodCartId, String key) throws UserException, FoodCartException;

}
