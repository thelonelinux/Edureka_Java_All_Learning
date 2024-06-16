package com.springaopdemo;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {

	public void addCustomer() {

		//spring jdbc or hibernate code

		System.out.println("customer created");
	}

	public void addCustomerData(int loanId, String customerName) {

		//spring jdbc or hibernate code

		System.out.println("customer data created");
	}

}
