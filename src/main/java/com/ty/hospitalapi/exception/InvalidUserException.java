package com.ty.hospitalapi.exception;

public class InvalidUserException extends RuntimeException{

	private String message="Invalid User ";

	public InvalidUserException() {}
	
	public InvalidUserException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
