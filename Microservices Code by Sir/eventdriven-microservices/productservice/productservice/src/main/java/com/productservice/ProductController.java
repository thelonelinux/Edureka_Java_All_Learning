package com.productservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Value("${productkey1}")
	String productkey;
	
	@GetMapping("/products")
	public String getProducts() {
		return "p1,p2,p3 "+productkey;
	}

}
