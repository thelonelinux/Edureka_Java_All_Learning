package com.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	
	@GetMapping("/orders")
	public String getOrders() {
		//for now hardcoding the result instead of getting database
		return "order1,order2,order3";
	}

}
