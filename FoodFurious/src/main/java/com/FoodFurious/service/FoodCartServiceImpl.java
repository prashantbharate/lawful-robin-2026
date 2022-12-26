package com.FoodFurious.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.FoodFurious.exceptions.FoodCartException;
import com.FoodFurious.exceptions.ItemException;
import com.FoodFurious.exceptions.UserException;
import com.FoodFurious.models.CurrentCustomerSession;
import com.FoodFurious.models.FoodCart;
import com.FoodFurious.models.Item;
import com.FoodFurious.repository.CustomerSessionDAO;
import com.FoodFurious.repository.FoodCartDAO;
import com.FoodFurious.repository.ItemDAO;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	CustomerSessionDAO customerSessionDAO;

	@Autowired
	FoodCartDAO foodCartDAO;

	@Autowired
	private ItemDAO itemDAO;

	@Override
	public FoodCart addItemToFoodCart(Integer foodCartId, Item item, String key)
			throws UserException, FoodCartException {

		CurrentCustomerSession loggedInUser = customerSessionDAO.findByUuid(key)
				.orElseThrow(() -> new UserException("Login in first..."));

		FoodCart savedFoodCart = foodCartDAO.findById(foodCartId)
				.orElseThrow(() -> new FoodCartException("no foodCart present..."));

		savedFoodCart.getItems().add(item);
		foodCartDAO.save(savedFoodCart);
		return savedFoodCart;

	}

	@Override
	public FoodCart increaseQuantity(Integer foodCartId, Integer itemId, Integer quantity, String key)
			throws UserException, FoodCartException {
		// TODO Auto-generated method stub

		CurrentCustomerSession loggedInUser = customerSessionDAO.findByUuid(key)
				.orElseThrow(() -> new UserException("Login in first..."));

		FoodCart savedFoodCart = foodCartDAO.findById(foodCartId)
				.orElseThrow(() -> new FoodCartException("no foodCart present..."));

		savedFoodCart.getItems().forEach(i -> {
			if (i.getItemId() == itemId) {
				i.setQuantity(i.getQuantity() + quantity);

			}
		});

		foodCartDAO.save(savedFoodCart);

		return savedFoodCart;
	}

	@Override
	public FoodCart reduceQuantity(Integer foodCartId, Integer itemId, Integer quantity, String key)
			throws UserException, FoodCartException {
		// TODO Auto-generated method stub

		CurrentCustomerSession loggedInUser = customerSessionDAO.findByUuid(key)
				.orElseThrow(() -> new UserException("Login in first..."));

		FoodCart savedFoodCart = foodCartDAO.findById(foodCartId)
				.orElseThrow(() -> new FoodCartException("no foodCart present..."));

		savedFoodCart.getItems().forEach(i -> {
			if (i.getItemId() == itemId) {
				i.setQuantity(i.getQuantity() - quantity);

			}
		});

		foodCartDAO.save(savedFoodCart);

		return savedFoodCart;
	}

	@Override
	public FoodCart removeItem(Integer foodCartId, Integer itemId, String key)
			throws UserException, FoodCartException, ItemException {
		// TODO Auto-generated method stub

		CurrentCustomerSession loggedInUser = customerSessionDAO.findByUuid(key)
				.orElseThrow(() -> new UserException("Login in first..."));

		FoodCart savedFoodCart = foodCartDAO.findById(foodCartId)
				.orElseThrow(() -> new FoodCartException("no foodCart present..."));

		Item existingItem = itemDAO.findById(itemId).orElseThrow(() -> new ItemException("no item found "));

		savedFoodCart.getItems().remove(existingItem);
		foodCartDAO.save(savedFoodCart);
		itemDAO.delete(existingItem);

		return savedFoodCart;

	}

	@Override
	public FoodCart clearCart(Integer foodCartId, String key) throws UserException, FoodCartException {

		CurrentCustomerSession loggedInUser = customerSessionDAO.findByUuid(key)
				.orElseThrow(() -> new UserException("Login in first..."));

		FoodCart savedFoodCart = foodCartDAO.findById(foodCartId)
				.orElseThrow(() -> new FoodCartException("no foodCart present..."));

		itemDAO.deleteAll();
		foodCartDAO.save(savedFoodCart);

		return savedFoodCart;
	}

}
