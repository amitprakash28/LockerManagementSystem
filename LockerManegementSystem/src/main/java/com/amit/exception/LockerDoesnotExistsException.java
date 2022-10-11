package com.amit.exception;

public class LockerDoesnotExistsException extends RuntimeException{

	public LockerDoesnotExistsException() {}
	
	public LockerDoesnotExistsException(String message) {
		super(message);
	}
	
	
}
