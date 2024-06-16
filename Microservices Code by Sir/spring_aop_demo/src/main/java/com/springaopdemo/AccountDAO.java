package com.springaopdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		// database operations using JDBC or Hibernate
		System.out.println("account created");
	}

	public void deleteAccount() {
		// database operations using JDBC or Hibernate
		System.out.println("account deleted");
	}

	public List<String> getAccounts() {
		// database operations using JDBC or Hibernate
		System.out.println("getting account data");
		return Arrays.asList("account1","account2");
		//throw new RuntimeException("data not found");
	}

}
