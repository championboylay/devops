package com.devoppsbuddy.web.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class PayLoadController {

	private final String PAYLOAD_VIEW_NAME="payload/payload";
	public String payload(){
		return PAYLOAD_VIEW_NAME;
	}
}
