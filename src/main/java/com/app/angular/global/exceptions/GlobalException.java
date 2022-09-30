package com.app.angular.global.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.angular.global.Dto.MessageDto;
import com.app.angular.utils.Operations;


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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDto> generalException(Exception e){
		return ResponseEntity.internalServerError()
				.body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException e){
		List<String> messages = new ArrayList<>();
		e.getBindingResult().getAllErrors().forEach((err)->{
			messages.add(err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, Operations.trimBrackts(messages.toString())));
	}
	

}
