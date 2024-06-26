package com.website.tychesoftwarellc.exception;

import lombok.Data;

@Data
public class ForbiddenOperationException extends RuntimeException {
	private String message;

	public ForbiddenOperationException(String message) {
		super();
		this.message = message;
	}
}
