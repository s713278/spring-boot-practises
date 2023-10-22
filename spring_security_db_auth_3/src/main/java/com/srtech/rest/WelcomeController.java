package com.srtech.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Non secured API
@RestController
@RequestMapping("/api")
public class WelcomeController {

	@GetMapping("/welcome/{name}")
	public String hello(@PathVariable String name) {
		return "Spring Security Welcomes "+name+"!!";
	}

}
