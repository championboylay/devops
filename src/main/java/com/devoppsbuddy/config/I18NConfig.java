package com.devoppsbuddy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18NConfig {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(I18NConfig.class);
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource resourceBundleMessage = new ReloadableResourceBundleMessageSource();
		resourceBundleMessage.setBasename("classpath:i18n/messages");
		
		resourceBundleMessage.setCacheMillis(1800);
		return resourceBundleMessage;
	}
}
