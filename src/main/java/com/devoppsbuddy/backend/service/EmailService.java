package com.devoppsbuddy.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.devoppsbuddy.web.domain.frontend.FeedBack;

public interface EmailService {
	public void sendFeedbackEmail(FeedBack feedback);
	public void sendGenericEmailMessage(SimpleMailMessage message);
	
}
