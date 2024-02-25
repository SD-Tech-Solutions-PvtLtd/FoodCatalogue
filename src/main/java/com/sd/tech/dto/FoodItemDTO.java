package com.sd.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
	
	private int id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private int price;
	private int restaurantId;
	private int quantity;


}
