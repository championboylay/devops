package com.devoppsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devoppsbuddy.backend.persistence.domain.backend.User;
import com.devoppsbuddy.backend.persistence.repositories.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	private static final Logger log = LoggerFactory.getLogger(UserSecurityService.class);

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		log.debug("User count is "+userRepository.findAll());
		User user = userRepository.findByUsername(arg0);
		if (null == user){
			log.warn("Username {} not found", arg0);
			throw new UsernameNotFoundException("Username "+arg0+" not foound.");
		}
		return user;
	}

}
