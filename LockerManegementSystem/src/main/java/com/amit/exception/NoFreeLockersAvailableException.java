package com.amit.exception;

public class NoFreeLockersAvailableException extends RuntimeException{

	public NoFreeLockersAvailableException() {}
	
	public NoFreeLockersAvailableException(String message) {
		super(message);
	}
}
