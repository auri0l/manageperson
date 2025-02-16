package com.course.manageperson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.course.manageperson.dto.ErrorEntity;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorEntity> notFoundHanler(UserNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorEntity(HttpStatus.NOT_FOUND, exception.getMessage()));
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorEntity> badRequestHandler(BadRequestException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorEntity(HttpStatus.BAD_REQUEST, exception.getMessage()));
	}

}
