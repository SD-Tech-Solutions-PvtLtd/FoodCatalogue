package com.sd.tech.service;

import org.springframework.http.ResponseEntity;

import com.sd.tech.dto.FoodItemCataloguePage;
import com.sd.tech.entity.FoodItem;

public interface FoodItemService {
	

	 ResponseEntity<FoodItem> saveItem(FoodItem foodItem);
	
	 ResponseEntity<FoodItem>  getByItemName(String name);

	 FoodItemCataloguePage fetchRestaurantAndFoodItemsById(Integer restaurantId);

}
