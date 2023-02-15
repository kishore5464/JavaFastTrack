package com.cts.sbrd.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.sbrd.exceptions.DuplicateEmployeeRecordExcepton;
import com.cts.sbrd.exceptions.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger;
	
	public GlobalExceptionHandler() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}

	@ExceptionHandler(DuplicateEmployeeRecordExcepton.class)
	public ResponseEntity<String> handleDuplicateEmployeeRecordExcepton(DuplicateEmployeeRecordExcepton exp){
		return new ResponseEntity<String>("An Employee with that ID already exists",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException exp){
		return new ResponseEntity<String>("An Employee with that ID is not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnhandledExceptions(Exception exp){
		logger.error(exp.getMessage(), exp);
		
		return new ResponseEntity<String>(
				"A server side exception occured or an exception is not handeled on the server",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
