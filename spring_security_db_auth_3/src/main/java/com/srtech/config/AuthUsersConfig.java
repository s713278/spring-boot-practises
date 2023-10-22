package com.srtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.srtech.service.MySQLUserDetailsService;

@Configuration
public class AuthUsersConfig {
	//The below is not required as We have provided custom implementation of UserDetailsService i.e MySQLUserDetailsService.java
	//@Bean
	public UserDetailsService userDetailsService() {
		//return new JdbcUserDetailsManager(datasource);
		return new MySQLUserDetailsService();
	}
	
	/**
	 * Password with hashing
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
