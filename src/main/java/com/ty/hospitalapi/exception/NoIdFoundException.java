package com.ty.hospitalapi.exception;

public class NoIdFoundException  extends RuntimeException{
	
	private String message="Id Not Exist";
	
	public NoIdFoundException() {}
	
	public NoIdFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
