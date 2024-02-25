package com.sd.tech.dto;

import java.util.List;

import com.sd.tech.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemCataloguePage {
	
	private List<FoodItem> foodItemsList;
	
	private Restaurant restaurant;
	
	

}
