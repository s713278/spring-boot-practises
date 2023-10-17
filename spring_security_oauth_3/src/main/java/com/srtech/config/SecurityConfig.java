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
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests((authReq)->authReq.requestMatchers("/api/account/**","/error").authenticated()
															  .requestMatchers("/api/bank/**").permitAll());
		httpSecurity.oauth2Login();
		httpSecurity.formLogin();
		httpSecurity.httpBasic();
		return httpSecurity.build();
	}
}
