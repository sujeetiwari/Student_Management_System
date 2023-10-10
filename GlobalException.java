package edu.sms.exceptions;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(
			ResourceNotFoundException ex)
	{
		ErrorDetails error = new ErrorDetails(new Date(),
				ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrityViolation(
			DataIntegrityViolationException ex)
	{
		ErrorDetails error = new ErrorDetails(new Date(),
				ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ServletException.class)
	public ResponseEntity<?> handleServletException(
			ServletException ex)
	{
		ErrorDetails error = new ErrorDetails(new Date(),
				ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
