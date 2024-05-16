package com.website.tychesoftwarellc.exception;

import lombok.Data;

@Data
public class SubscriberAlreadyPresent extends RuntimeException {
	private String message;

	public SubscriberAlreadyPresent(String message) {
		super();
		this.message = message;
	}
	
}
