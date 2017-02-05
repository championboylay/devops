package com.devoppsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String helloWorld(){
		// It will look from src/main/resources/templates
		return "index";
	}
}
