package com.website.tychesoftwarellc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.website.tychesoftwarellc.util.ErrorStructure;


@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ForbiddenOperationException.class)
	public ResponseEntity<ErrorStructure> emailAlreadyExist(ForbiddenOperationException foe) {
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		errorStructure.setRootCause("This Operation is Forbidden");
		errorStructure.setMessage(foe.getMessage());
		
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(UserAlreadyPresent.class)
	public ResponseEntity<ErrorStructure> userAlreadyPresent(UserAlreadyPresent uap) {
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatusCode(HttpStatus.CONFLICT.value());
		errorStructure.setRootCause("This User is already present");
		errorStructure.setMessage(uap.getMessage());
		
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(SubscriberAlreadyPresent.class)
	public ResponseEntity<ErrorStructure> subscriberAlreadyPresent(SubscriberAlreadyPresent sap) {
		ErrorStructure errorStructure = new ErrorStructure();
		errorStructure.setStatusCode(HttpStatus.CONFLICT.value());
		errorStructure.setRootCause("You have already subscribed");
		errorStructure.setMessage(sap.getMessage());
		
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.CONFLICT);
	}
}
