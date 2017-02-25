package com.devoppsbuddy.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.devoppsbuddy.web.domain.frontend.FeedBack;

public abstract class AbstractEmailService implements EmailService{

	@Value("${default.to.address}")
	private String defaultToAddress;
	
	protected SimpleMailMessage prepareSimpleMailMessage(FeedBack feedback){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(defaultToAddress);
		message.setFrom(feedback.getEmail());
		message.setSubject("Feedback message received from "+feedback.getFirstName() + " "+feedback.getLastName()+" !");
		message.setText(feedback.getFeedBack());
		return message;
	}
	
	public void sendFeedbackEmail(FeedBack fb){
		sendGenericEmailMessage(prepareSimpleMailMessage(fb));
	}
}
