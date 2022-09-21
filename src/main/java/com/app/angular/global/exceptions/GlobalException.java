package com.app.angular.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.angular.global.Dto.MessageDto;


@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()));
	}
	
	@ExceptionHandler(AttributeException.class)
	public ResponseEntity<MessageDto> throwNotFoundException(AttributeException e){
		return ResponseEntity.badRequest()
				.body(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()));
	}
	

}
