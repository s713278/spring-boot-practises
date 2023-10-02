package com.srtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.srtech.remote.RemoteService;

@SpringBootApplication
public class WebClientDemoApp {

	/*
	 * @Bean public WebClient webClient() { return WebClient.create(); }
	 * 
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext= SpringApplication.run(WebClientDemoApp.class, args);
		RemoteService remoteService = applicationContext.getBean(RemoteService.class);
		System.out.println("Mono Response :"+remoteService.getRandomUser());
		
		System.out.println("Flux Response :"+remoteService.getRandomUsers(3));
		//applicationContext.close();
		
	}

	
}
