package com.springcoredemo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//the class marked with @Configuration is defined to be configuration for spring container
//in this class, we will tell to spring container or application which beans to be created
@Configuration
public class AppConfig {
	
	//this annotation will tell application context that this method
	//contains the employee object to be created
	//by default the method name is beanid
	//now the bean id is not employee it is emp
	@Bean("emp")
	public Employee employee() {
		return new Employee();
	}
	
	@Bean
	public Department department() {
		return new Department();
	}

}
