package com.srtech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.github.javafaker.Faker;

@SpringBootApplication
public class RestClientDemoApp {

	private static final String BASE_URL = "https://random-data-api.com/";
	private static final String URL = "/api/bank/random_bank";

	RestClient client = null;

	public RestClientDemoApp() {
		client = RestClient.create(BASE_URL);
	}

	public void restClientWithObjectResponse() {
		String response = client
				.get()
				.uri(URL)
				.retrieve()
				.body(String.class);
		System.out.println(" Response \n\n\t:" + response);
	}

	public void restClientWithEntityResponse() {
		ResponseEntity<String> responseEntity = client
				.get()
				.uri(URL)
				.retrieve()
				.toEntity(String.class);
		// System.out.println(" \n ResponseEntity \n\n\t:"+responseEntity);
		System.out.println("Response status: " + responseEntity.getStatusCode());
		System.out.println("Response headers: " + responseEntity.getHeaders());
		System.out.println("Response Contents: " + responseEntity.getBody());
	}

	public static void main(String[] args) throws Exception{

		ConfigurableApplicationContext applicationContext = SpringApplication.run(RestClientDemoApp.class, args);
		RestClientDemoApp app=new RestClientDemoApp();
	//	app.restClientWithEntityResponse();
		//app.restClientWithObjectResponse();
		
		MathService mathService = applicationContext.getBean(MathService.class);
		Faker faker= new Faker();
		
		Runnable task = () ->  System.out.println(mathService.getLuckyNumber("K Swamy"));
		
		//Thread thread=new Thread(task);
		//thread.start();
		
		
		Thread thread2= Thread.startVirtualThread(task);
		System.out.println("Is Virtual ?"+thread2.isVirtual()); 
		thread2.start();
		
		Thread thread3=Thread.ofVirtual().start(task);
		System.out.println("Is Virtual ?"+thread3.isVirtual());
		thread3.start();
		
		ExecutorService executor= Executors.newVirtualThreadPerTaskExecutor();
		System.out.println(executor.submit(task).get());
		
		applicationContext.close();
		
	}

}
