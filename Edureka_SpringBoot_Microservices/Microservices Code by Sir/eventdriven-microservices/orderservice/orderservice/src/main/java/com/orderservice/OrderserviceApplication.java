package com.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//this annotation will tell that this service is a discovery client that gets
//registered with discovery service
public class OrderserviceApplication {

	public static void main(String[] args) {
		if(args.length > 0) {
			System.setProperty("server.port", args[0]);
		}
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}
