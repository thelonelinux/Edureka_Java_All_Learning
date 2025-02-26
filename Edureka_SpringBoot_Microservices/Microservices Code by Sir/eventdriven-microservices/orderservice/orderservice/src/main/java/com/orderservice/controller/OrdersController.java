package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.entity.Order;
import com.orderservice.service.OrderService;

@RestController
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public String getOrders() {
		return "o1,o2,o3";
	}
	
	@PostMapping("/orders")
	public String createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	

}
