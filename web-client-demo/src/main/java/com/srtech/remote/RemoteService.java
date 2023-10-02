package com.srtech.remote;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RemoteService {

	private static final String BASE_URL = "https://random-data-api.com/";
	private static final String RANDOM_USER_URI = "/api/users/random_user";
	private static final String RANDOM_USERS_URI = "/api/users/random_user";

	private WebClient webClient;

	public RemoteService() {
		webClient = WebClient.create(BASE_URL);
	}

	public Mono<String> getRandomUser() {
		Mono<String> randomUser = webClient
								.get()
								.uri(RANDOM_USER_URI)
								.retrieve()
								.bodyToMono(String.class)
								.log();
		return randomUser;
	}
	
	public Flux<String> getRandomUsers(int size) {
		Flux<String> randomUsers = webClient
								.get()
								.uri(RANDOM_USERS_URI+"?size="+size)
								.retrieve()
								.bodyToFlux(String.class)
								.log();
		return randomUsers;
	}
}
