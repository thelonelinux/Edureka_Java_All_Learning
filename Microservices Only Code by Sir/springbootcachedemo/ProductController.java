package com.springbootcachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable String id) {
		return productService.getProductById(id);
	}

}
