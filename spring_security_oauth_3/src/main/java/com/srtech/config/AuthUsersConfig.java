package com.srtech.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class AuthUsersConfig {

	/**
	 * Commented the below fpr No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken
	 * As This module included customized user login functionality
	 * @param dataSource
	 * @return
	 */
	//@Bean
	/*
	 * public UserDetailsService defaultUsers(DataSource dataSource) { return new
	 * JdbcUserDetailsManager(dataSource); }
	 */
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
