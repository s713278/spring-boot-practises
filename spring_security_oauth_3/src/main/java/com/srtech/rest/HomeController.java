package com.srtech.rest;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Non secured API
@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public String hello() {
		return "Secured Response After OAuth2.0 Authentication!!";
	}
	
	@GetMapping("/callback")
	public String gitHubCallBack(OAuth2AuthenticationToken token) {
		System.out.println("OAuth2AuthenticationToken\t"+token);
		return "index.html";
	}

}
