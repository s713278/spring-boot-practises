package com.srtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
		return new BCryptPasswordEncoder(15);
	}
}
