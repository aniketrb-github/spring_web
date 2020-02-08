package com.arbtech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Exception handler with respective HHTP Status code
 * 
 * @author Aniket Bharsakale
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6660577246967578481L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
