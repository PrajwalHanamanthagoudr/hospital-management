package com.ty.hospitalapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.hospitalapi.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdFoundExceptionHandler(NoIdFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<ResponseStructure<String>> userInvalidExceptionHandler(InvalidUserException userException) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Invalid");
		responseStructure.setData(userException.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
