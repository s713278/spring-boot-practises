package com.srtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.srtech.model.User;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

	@GetMapping("/signUp")
	public ModelAndView handleSignUp(Model model ) {
		ModelAndView modelAndView=new ModelAndView("signUp");
		modelAndView.addObject("user",new User());
		return modelAndView;
	}
	
	@PostMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("user") User user ,BindingResult bindingResult) {
		System.out.println("User entered details : "+user);
		ModelAndView modelAndView=new ModelAndView("signUp");
		if(bindingResult.hasErrors()) {
			System.out.println("Form has errors.");
			bindingResult.getAllErrors().stream().forEach(objectFormError-> System.out.print(objectFormError.getObjectName()));
			modelAndView.addObject("user",user);
			return modelAndView;
			
		}
		//log.info("message");
		modelAndView=new ModelAndView("user_success");
		modelAndView.addObject("message","User registration success!!");
		return modelAndView;
	}
}
