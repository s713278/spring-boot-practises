package com.srtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is to demonstrate to fetch the user name and pwd from own tables and validates using Custom Authentication Provider i.e MyAuthenticationProvider.java
 */
@SpringBootApplication
public class CustomAuthenticationProviderTest {

	public static void main(String[] args) {
		SpringApplication.run(CustomAuthenticationProviderTest.class, args);
	}

}
