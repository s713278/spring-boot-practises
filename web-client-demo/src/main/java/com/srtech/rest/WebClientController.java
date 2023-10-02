package com.srtech.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.srtech.remote.LocalService;
import com.srtech.remote.RemoteService;
import com.srtech.remote.dto.MathRequest;
import com.srtech.remote.dto.MathResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/reactive")
public class WebClientController {

	private RemoteService remoteService;
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	public void setRemoteService(RemoteService remoteService) {
		this.remoteService = remoteService;
	}

	@GetMapping(value = "/randomUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> getRandomUser() {
		return remoteService.getRandomUser();
	}
	
	@GetMapping(value = "/randomUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<String> getRandomUsers(@RequestParam Integer size) {
		return remoteService.getRandomUsers(size);
	}
	
	@PostMapping(value = "/maths",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Mono<MathResponse> maths(@RequestBody MathRequest request){
		//log.debug("message");
		System.out.println("Math Request after Change "+request);
		if(request.getNo1() == null) {
			request.setNo1(10);
			request.setNo2(30);
			request.setMathOperator("+");
		}
		return localService.maths(request);
		
	}
	
	@GetMapping(value = "/maths/febenacci/{howMany}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<List>> febanacci(@PathVariable Integer howMany) {
		System.out.println("howMany value "+howMany);
		return localService.febanacci(howMany);
	}
}
