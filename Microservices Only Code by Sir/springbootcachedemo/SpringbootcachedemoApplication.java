package com.springbootcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootcachedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcachedemoApplication.class, args);
	}

}
