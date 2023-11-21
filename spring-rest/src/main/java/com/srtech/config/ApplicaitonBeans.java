package com.srtech.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.srtech.filter.ReqResLogFilter;

@Configuration
public class ApplicaitonBeans {

	@Bean
	public FilterRegistrationBean<ReqResLogFilter> loggingFilter() {
		FilterRegistrationBean<ReqResLogFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new ReqResLogFilter());
		registrationBean.addUrlPatterns("/api/*"); // Specify the URL patterns to filter
		return registrationBean;
	}
	
}
