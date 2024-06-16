package com.springaopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication  
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = SpringApplication.run(App.class, args);
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
        //calling the business method
        accountDAO.addAccount();
       System.out.println(accountDAO.getAccounts());
       // accountDAO.deleteAccount();*/
        
        CustomerDAO customerDAO = context.getBean("customerDAO",CustomerDAO.class);
        customerDAO.addCustomer();
        customerDAO.addCustomerData(1, "vivek");
        
    }
}
