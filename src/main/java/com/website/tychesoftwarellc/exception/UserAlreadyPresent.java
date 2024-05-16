package com.website.tychesoftwarellc.exception;

import lombok.Data;

@Data
public class UserAlreadyPresent extends RuntimeException {
	private String message;

	public UserAlreadyPresent(String message) {
		super();
		this.message = message;
	}
	
}
