package com.arbtech.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Customized Exception handler for all controller/resources of application
 * 
 * @author Aniket Bharsakale
 */

@ControllerAdvice	// To make it application across all controllers in our application
@RestController		// Since it will return a response after exception is encountered
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	// Provides handling for standard Spring MVC exceptions
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleAllExceptions(Exception exception, WebRequest webRequest) {
		
		// Populating our baseException model with required data
		BaseExceptionResponse exceptionResponse = new BaseExceptionResponse(new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// Provides handling for standard Spring MVC exceptions
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<?> handleUserNotFoundException(Exception exception, WebRequest webRequest) {
		
		// Populating our baseException model with required data
		BaseExceptionResponse exceptionResponse = new BaseExceptionResponse(new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// Populating our baseException model with required data
		BaseExceptionResponse exceptionResponse = new BaseExceptionResponse(new Date(), "Validation Failed!",
				ex.getBindingResult().toString());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);	
	}
}
