package com.sd.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.tech.dto.Restaurant;
import com.sd.tech.feign.client.FeignClientServer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	@Autowired
	FeignClientServer feignClientServer;
	
	int count=1;
	
	
	@CircuitBreaker(name = "restaurantService", fallbackMethod = "fallbackFetchRestaurantDetailsFromRestaurantMS")
	public Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantID)
	{
		//return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantID, Restaurant.class);
		System.out.println("restaurant service call count is :: "+count);
		count ++;
		Restaurant restaurant = feignClientServer.fetchRestaurantDetailsFromRestaurantMS(restaurantID);
		return restaurant;
	}
	
	public Restaurant fallbackFetchRestaurantDetailsFromRestaurantMS(Integer restaurantID, Throwable th)
	{
		System.out.println("error is ::: "+th);
		return new Restaurant();
	}
	
	

}
