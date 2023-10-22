package com.srtech.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Secured API
@RestController
@RequestMapping("/api/account")
public class AccountController {

	@GetMapping("/details")
	public String getAccountDetails() {
		return "My Account Details";
	}

	@GetMapping("/cards")
	public String getCardDetails() {
		return "My Cards";
	}

}
