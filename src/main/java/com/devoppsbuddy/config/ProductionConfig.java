package com.devoppsbuddy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("pro")
@PropertySource("C:\\devoppbuddy\\application-pro.properties")
public class ProductionConfig {
	
}
