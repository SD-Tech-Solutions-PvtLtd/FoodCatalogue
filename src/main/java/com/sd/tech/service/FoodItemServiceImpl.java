package com.sd.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sd.tech.dto.FoodItemCataloguePage;
import com.sd.tech.dto.Restaurant;
import com.sd.tech.entity.FoodItem;
import com.sd.tech.repo.FoodItemRepo;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	
	@Autowired
	private FoodItemRepo foodItemRepo;
	
	@Autowired
	private RestTemplate restTemplate; 

	@Override
	public ResponseEntity<FoodItem> saveItem(FoodItem foodItem) {
		if(foodItem!=null)
		{
			FoodItem foodItemDetails = foodItemRepo.saveAndFlush(foodItem);
			 return new ResponseEntity<>(foodItemDetails, org.springframework.http.HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(null, org.springframework.http.HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<FoodItem> getByItemName(String name) {
		FoodItem foodItemData = foodItemRepo.findByItemName(name);
		 if(foodItemData!=null)
		 {
			 return new ResponseEntity<>(foodItemData, org.springframework.http.HttpStatus.FOUND);

		 }
	else
	{
		return new ResponseEntity<>(null, org.springframework.http.HttpStatus.NOT_FOUND);
	}
	}

	@Override
	public FoodItemCataloguePage fetchRestaurantAndFoodItemsById(Integer restaurantId) {
		List<FoodItem> foodItemsList= fetchFoodItemList(restaurantId);
		 Restaurant restaurant= fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		 return createFoodCataloguePage(foodItemsList,restaurant);
		 
		 
	}
	
	private FoodItemCataloguePage createFoodCataloguePage(List<FoodItem> foodItemsList,Restaurant restaurant)
	{
		
		FoodItemCataloguePage foodItemCataloguePage=new FoodItemCataloguePage();
		foodItemCataloguePage.setFoodItemsList(foodItemsList);
		foodItemCataloguePage.setRestaurant(restaurant);
		return foodItemCataloguePage;
		
	}
	
	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantID)
	{
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantID, Restaurant.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId)
	{
		return foodItemRepo.findByRestaurantId(restaurantId);
	}
	
}
