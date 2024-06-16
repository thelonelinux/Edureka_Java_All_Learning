package com.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductserviceController {
	
	@GetMapping("/products")
	public String getProducts() {
		return "product1, product2, product3";
	}

}
