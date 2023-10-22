package com.srtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is to demonstrate to fetch the user name and pwd from own tables rather than out of box spring security framework tables. 
 * 1. Password Hashing
 * 2/ Custom DAtabase user name and password validation
 * 3/ Custom UserDeailsService Implementation
 */
@SpringBootApplication
public class SecurityWithPwdHasing {

	public static void main(String[] args) {
		SpringApplication.run(SecurityWithPwdHasing.class, args);
	}

}
