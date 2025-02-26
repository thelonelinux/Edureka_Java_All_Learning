package com.springrestapidemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration defines configuration for spring beans
@Configuration
//@ComponentScan scans for the @Components and create spring beans
@ComponentScan
//@EnableWebMvc will enable mvc functionality(like dispatcher servlet loading
//this will work with jackson libraries to convert json to java and java to json
@EnableWebMvc
public class WebConfig {

}
