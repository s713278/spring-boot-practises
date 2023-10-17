package com.srtech.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class AuthUsersConfig {
//Approach-1: With default password encoder
//Enable the below comment to enable the approach#1
	//@Bean
	public UserDetailsService defaultUsers1() {
		
		UserDetails adminUser= User.withDefaultPasswordEncoder()
		.username("admin")
		.password("admin1234")
		.authorities("admin")
		.build();
		

		UserDetails readUser= User.withDefaultPasswordEncoder()
		.username("read")
		.password("read1234")
		.authorities("read")
		.build();
		
		

		UserDetails writeUser= User.withDefaultPasswordEncoder()
		.username("write")
		.password("write1234")
		.authorities("write")
		.build();
		
		return new InMemoryUserDetailsManager(adminUser,readUser,writeUser);
	}
	
	//Approach-2: With default No password encoder
	//Enable the below comment to enable the approach#2
	//@Bean
	public UserDetailsService defaultUsers2() {
		
		UserDetails adminUser= User.withUsername("admin")
		.password("admin1234")
		.authorities("admin")
		.build();
		

		UserDetails readUser= User.withUsername("read")
		.password("read1234")
		.authorities("read")
		.build();
		
		

		UserDetails writeUser= User.withUsername("write")
		.password("write1234")
		.authorities("write")
		.build();
		
		return new InMemoryUserDetailsManager(adminUser,readUser,writeUser);
	}
	
	//Approach-3 for interacting eith mysql db
	@Bean
	public UserDetailsService defaultUsers3(DataSource datasource) {
		return new JdbcUserDetailsManager(datasource);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
