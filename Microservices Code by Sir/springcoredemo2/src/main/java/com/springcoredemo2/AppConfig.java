package com.springcoredemo2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//the class marked with @Configuration is defined to be configuration for spring container
//in this class, we will tell to spring container or application which beans to be created
@Configuration
//application context will scan for the classes marked with @Component and creates 
//spring beans automatically 
@ComponentScan
public class AppConfig {
	
	

}
