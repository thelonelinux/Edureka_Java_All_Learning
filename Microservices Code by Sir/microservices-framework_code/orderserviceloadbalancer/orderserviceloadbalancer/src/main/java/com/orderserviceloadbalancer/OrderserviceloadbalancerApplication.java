package com.orderserviceloadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderserviceloadbalancerApplication {

	public static void main(String[] args) {
		if(args.length > 0) {
			System.setProperty("server.port", args[0]);
		}
		SpringApplication.run(OrderserviceloadbalancerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
