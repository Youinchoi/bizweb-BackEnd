package com.bizweb.sample.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bizweb.sample.config.ErrorCodeConfig;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
	        ApiErrorResponse response = new ApiErrorResponse("에러발생~", ex.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }*/
	

	 @Autowired
	    private ErrorCodeConfig errorCodeConfig;

	@ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
            errorCodeConfig.getServerErrorMessage(), 
            HttpStatus.valueOf(errorCodeConfig.getServerErrorCode())
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
            errorCodeConfig.getNotFoundMessage(), 
            HttpStatus.valueOf(errorCodeConfig.getNotFoundCode())
        );
    }
	 
}
