package com.amit.exception;

public class UserDoesnotExistsException extends RuntimeException{

	public UserDoesnotExistsException() {}
	
	public UserDoesnotExistsException(String message) {
		super(message);
	}
}
