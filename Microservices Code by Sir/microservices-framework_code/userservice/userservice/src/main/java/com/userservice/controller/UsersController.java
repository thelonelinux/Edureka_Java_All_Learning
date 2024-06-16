package com.userservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//this annotation gives scope for refreshing the custom properties injected through @Value
@RefreshScope
public class UsersController {
	
	//this will inject the property value referred from the key mykey1
	@Value("${mykey1}")
	private String key;
	
	@GetMapping("/users")
	public String getUsers() {
		return "user1,user2,user3 "+key;
	}

}
