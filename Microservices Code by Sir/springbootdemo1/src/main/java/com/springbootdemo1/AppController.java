package com.springbootdemo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a child annotation of @Component where handler mapping
@RestController
public class AppController {
	
	//api or end point
	//this will handle GET /customers request
	@GetMapping("/customers")
	public Customer getCustomer() {
		//this should connect to database, get the data from customers table
		
		//for now hardcoding the data
		Customer customer = new Customer();
		customer.setCustomerId("c100");
		customer.setCustomerName("Ravi");
		customer.setCustomerCity("Bangalore");
		
		return customer;
	}
	
	//in http post request, we send request body while invoking the url
	//request body is in json when sending from client
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		//add this customer data to database
		System.out.println(customer.getCustomerId()+" "+customer.getCustomerName());
		return customer;
	}
	

}
