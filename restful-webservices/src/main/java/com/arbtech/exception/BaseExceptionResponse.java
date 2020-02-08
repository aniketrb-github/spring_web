package com.arbtech.exception;

import java.util.Date;

/**
 * Generic Base class model for Exception response
 * Standard exception response across the application
 * 
 * @author Aniket Bharsakale
 */
public class BaseExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public BaseExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
