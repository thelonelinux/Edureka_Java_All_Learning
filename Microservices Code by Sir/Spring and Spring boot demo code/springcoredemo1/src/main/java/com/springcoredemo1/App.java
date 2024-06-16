package com.springcoredemo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        //Employee emp = new Employee();
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	Employee emp = context.getBean("emp",Employee.class);
    	Department department = context.getBean("department",Department.class);
    	System.out.println(emp.getDepartment());
    	System.out.println(department);
    }
}
