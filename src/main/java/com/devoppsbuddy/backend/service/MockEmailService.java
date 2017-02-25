package com.devoppsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import groovy.util.logging.Log;

public class MockEmailService extends AbstractEmailService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendGenericEmailMessage(SimpleMailMessage message) {
		LOGGER.debug("Simulating email service");
		
		
	}
	

}
