package com.codedecode.microservices.EurekaServer;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final HttpStatus NOT_FOUND = null;

	/*
	 * @ExceptionHandler(UserNotFoundException.class) public
	 * ResponseEntity<String>userNotFoundException(UserNotFoundException ex) {
	 * return new
	 * ResponseEntity<String>("input field is empty ",HttpStatus.BAD_REQUEST); }
	 */

	@ExceptionHandler({UserNotFoundException.class,IdNotFoundException.class})
	protected ResponseEntity<ApiError> handleEntityNotFound(RuntimeException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(ex.getMessage());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}


}

/*
 * private ResponseEntity<User> buildResponseEntity(ApiError apiError) { // TODO
 * Auto-generated method stub return null; } }
 * 
 * 
 * /* @Order(Ordered.HIGHEST_PRECEDENCE)
 * 
 * @ControllerAdvice public class RestExceptionHandler extends
 * ResponseEntityExceptionHandler {
 * 
 * //other exception handlers
 * 
 * @ExceptionHandler(EntityNotFoundException.class) protected
 * ResponseEntity<Object> handleEntityNotFound( EntityNotFoundException ex) {
 * ApiError apiError = new ApiError(NOT_FOUND);
 * apiError.setMessage(ex.getMessage()); return buildResponseEntity(apiError); }
 * }
 */
