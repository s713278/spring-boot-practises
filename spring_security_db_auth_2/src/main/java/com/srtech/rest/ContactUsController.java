package com.srtech.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Non secured API
@RestController
@RequestMapping("/api/bank")
public class ContactUsController {


	@GetMapping("/contactUs")
	public String contactUs() {
		return "Ccntact Us";
	}
	
	@GetMapping("/notifications")
	public String notifications() {
		return "Notifications";
	}
}
