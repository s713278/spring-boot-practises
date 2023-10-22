package com.srtech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This is for project specific security configuration
 */
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/api/account/**").authenticated());
		http.authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/api/bank/**").permitAll());
		http.formLogin(t -> t.isCustomLoginPage() );
		http.httpBasic();
		return http.build();
	}
}
