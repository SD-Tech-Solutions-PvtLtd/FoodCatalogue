package com.sd.tech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.tech.entity.FoodItem;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Integer>{
	
	FoodItem findByItemName(String name);

	List<FoodItem> findByRestaurantId(Integer restaurantId);


}
