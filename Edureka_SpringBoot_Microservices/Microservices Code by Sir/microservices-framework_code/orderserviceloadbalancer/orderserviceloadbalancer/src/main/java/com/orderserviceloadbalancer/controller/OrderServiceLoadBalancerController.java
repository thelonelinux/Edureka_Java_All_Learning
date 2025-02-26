package com.orderserviceloadbalancer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrderServiceLoadBalancerController {
	
	//LoadBalancerClientFactory is created by spring boot auto configuration
	//by seeing the spring cloud loadbalancer library in class path
	//LoadBalancerClientFactory is factory class to create loadbalancer object
	@Autowired
	LoadBalancerClientFactory clientFactory;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@CircuitBreaker(name="ordersservicebackup", fallbackMethod="fallbackforOrders")
	@GetMapping("/orders")
	public String getOrders() {
		System.out.println("in orderservice load balancer");
		//logic of load balancing to orderservice instances
		//1. connect to Eureka server and get the address details of ORDERSERVICE
		//2. Eureka server will respond with address details of ORDERSERVICE(one or more instance)
		//3. It will chose one instance and send the request to that instance
		
		//single line of the code will connet to Eureka server, get the address deatils
		//of ORDERSERVICE, Eureka server will respond with address details of ORDERSERVICE
		//this gets assigned to RoundRobinLoadBalancer object
		RoundRobinLoadBalancer lb = clientFactory.getInstance("ORDERSERVICE", RoundRobinLoadBalancer.class);
		
		//load balancer willl choose one instance of orderservice instance
		ServiceInstance instance = lb.choose().block().getServer();
		
		String host = instance.getHost();
		int port = instance.getPort();
		
		String url = "http://"+host+":"+port+"/orders";
		System.out.println(url);
		String response = restTemplate.getForObject(url, String.class);
	
		return response;
		
	}
	
	//this is the bakup or fallback mechanism triggered by circuitbreaker
	//circuitbreaker will throw CallNotPermittedException whenever it changes to openstate
	public String fallbackforOrders(CallNotPermittedException ex) {
		//logic to get data from cache
		return "response from fallback service";
	}
}
