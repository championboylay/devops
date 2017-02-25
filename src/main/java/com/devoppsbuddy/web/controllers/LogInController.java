package com.devoppsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogInController {

	private final String LOGIN = "user/login";
	
	@RequestMapping("/login")
	public String login(){
		return LOGIN;
	}
}
