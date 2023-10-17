package com.srtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is to demonstrate with multiple applicaiton users authntication from memory/mysql database.
 * In this example,
 * We have 3 uesrs with 3 roles
 * admin-->admin
 * read-->read
 * write-->write
 */
@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
