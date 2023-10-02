package com.srtech.remote;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.srtech.remote.dto.MathRequest;
import com.srtech.remote.dto.MathResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LocalService {
	//http://localhost:9091/api/maths/
	private static final String BASE_URL="http://localhost:9091/api";
	
	private static final String POST_MATHS_URI ="/maths/";
	
	private static final String GET_FEBANACCI_URI ="/febenacci/";
	
	private WebClient mathsWebClient;
	public LocalService() {
		mathsWebClient = WebClient.create(BASE_URL);
	}

	public Mono<MathResponse> maths(MathRequest request ){
		System.out.println("Math Request "+request);
		return mathsWebClient
		.post()
		.uri(POST_MATHS_URI)
		.body(Mono.just(request),MathRequest.class)
		.retrieve()
		.bodyToMono(MathResponse.class)
		.log();
		
		/*
		 * mathsWebClient.post() .uri(POST_MATHS_URI) .body(Mono.just(request),
		 * MathRequest.class) .retrieve() .toEntity(MathResponse.class); }
		 */
	}
	
	//http://localhost:9091/api/maths/febenacci/2
	public Mono<ResponseEntity<List>> febanacci(int howMany){
		return mathsWebClient
		.get()
		.uri(GET_FEBANACCI_URI+howMany)
		.retrieve()
		.toEntity(List.class);
	}
	
	
}
