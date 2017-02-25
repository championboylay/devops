package com.devoppsbuddy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devoppsbuddy.backend.service.EmailService;
import com.devoppsbuddy.backend.service.MockEmailService;

@Configuration
@Profile("dev")
@PropertySource("C:\\\\devoppbuddy\\application-dev.properties")
public class DevelopmentConfig {
	
	public EmailService emailService(){
		return new MockEmailService();
	}

}
