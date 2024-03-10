package com.sd.tech.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sd.tech.dto.Restaurant;

@FeignClient(value = "api-gateway")
public interface FeignClientServer {
	
	@GetMapping("restaurant-service/restaurant/fetchById/{id}")
	public Restaurant fetchRestaurantDetailsFromRestaurantMS(@PathVariable Integer id);

}
