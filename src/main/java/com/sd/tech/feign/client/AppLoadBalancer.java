package com.sd.tech.feign.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "RESTAURANT-SERVICE")
public class AppLoadBalancer {
	
	
	@Bean
	@LoadBalanced
	public Feign.Builder feignBuilder()
	{
		return Feign.builder();
	}

}
