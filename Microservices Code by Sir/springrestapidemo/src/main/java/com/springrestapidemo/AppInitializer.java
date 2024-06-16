package com.springrestapidemo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//AbstractAnnotationConfigDispatcherServletInitializer used to register DispatcherServlet
//this will work like web.xml where any url pattern will be sent to DispatcherServlet
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//providing configuration to dispatcher servlet
	//dispatcher servlet will use handler mapping and handler adapter where these helper
	//classes will use WebConfig class to create spring beans, manage spring beans
	//in this mvc framework
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[]{WebConfig.class};
	}

	//any reuest from the url path / will be sent to dispatcher servlet 
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
