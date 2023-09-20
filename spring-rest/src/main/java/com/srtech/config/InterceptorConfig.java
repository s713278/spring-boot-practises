package com.srtech.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.srtech.filter.MyInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer  {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor());
	}
    
   
}
