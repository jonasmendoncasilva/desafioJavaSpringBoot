package com.project.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError ex = new StandardError(Instant.now(),status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ex);		
	}

	@ExceptionHandler(KeywordNotFoundException.class)
	public ResponseEntity<StandardError> keywordNotFound(KeywordNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError ex = new StandardError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ex);		
	}

	@ExceptionHandler(EntityWithSameDataException.class)
	public ResponseEntity<StandardError> entityWithSameData(EntityWithSameDataException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError ex = new StandardError(Instant.now(),status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ex);		
	}
	
	@ExceptionHandler(EntityNotFoundToDeleteException.class)
	public ResponseEntity<StandardError> entityNotFoundToDelete(EntityNotFoundToDeleteException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError ex = new StandardError(Instant.now(),status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(ex);		
	}
}
