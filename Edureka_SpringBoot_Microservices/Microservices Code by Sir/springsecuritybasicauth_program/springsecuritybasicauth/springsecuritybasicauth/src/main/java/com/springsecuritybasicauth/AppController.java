package com.springsecuritybasicauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	
	//this api can be accessed by admin role, user role, manager role
	@GetMapping("/orders")
	public String getOrders() {
		return "order1,order2,order3";
	}
	
	//this api can be accessed only by admin role
	//user role and manager role cannot access this
	@GetMapping("/admin")
	public String getAllUsersOrders() {
		return "order1-user1, order2-user2, order3-user3";
	}

}
