package com.devoppsbuddy.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private final String authority;
	
	public Authority(String authority) {
		// TODO Auto-generated constructor stub
		this.authority = authority;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

	
}
