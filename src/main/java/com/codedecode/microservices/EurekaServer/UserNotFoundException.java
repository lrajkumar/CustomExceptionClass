package com.codedecode.microservices.EurekaServer;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String mes) {
		super(mes);
	}

	//private static final long serialVersionUID =1L;
	
	
}
