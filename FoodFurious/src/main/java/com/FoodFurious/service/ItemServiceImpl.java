package com.FoodFurious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.ItemException;
import com.FoodFurious.models.Item;
import com.FoodFurious.repository.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;

	@Override
	public Item addItems(Item item) {

		Item savedItem = itemDAO.save(item);
		return savedItem;

	}

	@Override
	public List<Item> getAllItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item updateitem(Item item) throws ItemException {

		itemDAO.findById(item.getItemId()).orElseThrow(() -> new ItemException("item not found..."));
		itemDAO.save(item);
		return item;
	}

	@Override
	public Item removeItem(Integer itemId) throws ItemException {
		// TODO Auto-generated method stub
		Item removeItem = itemDAO.findById(itemId).orElseThrow(() -> new ItemException("item not found..."));
		itemDAO.deleteById(itemId);

		return removeItem;
	}

	@Override
	public Item getItemByName(String Iname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		Item existingItem = itemDAO.findById(itemId).orElseThrow(() -> new ItemException("Item not found..."));
		return existingItem;
	}

}
