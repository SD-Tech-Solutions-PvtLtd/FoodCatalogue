package com.sd.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tech.dto.FoodItemCataloguePage;
import com.sd.tech.entity.FoodItem;
import com.sd.tech.service.FoodItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/foodItem")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodItemController {
	
	
	@Autowired
	private FoodItemService foodItemService;
	
	 ResponseEntity<FoodItem> savedFoodItem;
	 ResponseEntity<FoodItem>  foodInfo;
	 FoodItemCataloguePage fetchRestaurantAndFoodItemsById; 
	
	

	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItem> addFoodItemInfo(@RequestBody FoodItem foodItem)
	{
		try
		{
			savedFoodItem= foodItemService.saveItem(foodItem);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return savedFoodItem;
		
	}


	@GetMapping("/findByName")
	public ResponseEntity<FoodItem>  getByNameFoodItem(@RequestParam String name)
	{
		try
		{
			foodInfo= foodItemService.getByItemName(name);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return foodInfo;
		
	}
	

	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public FoodItemCataloguePage  fetchRestaurantAndFoodItemsById(@PathVariable Integer restaurantId)
	{
		try
		{
			log.info("inside fetchRestaurantAndFoodItemsById .... ");
			fetchRestaurantAndFoodItemsById = foodItemService.fetchRestaurantAndFoodItemsById(restaurantId);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return fetchRestaurantAndFoodItemsById;
		
	}

}
