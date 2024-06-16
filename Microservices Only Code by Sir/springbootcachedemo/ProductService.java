package com.springbootcachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Cacheable(value="product", key="#id")
	public Product getProductById(String id) {
		System.out.println("fetching from database products table");
		return productRepository.findById(id).get();
	}

}
