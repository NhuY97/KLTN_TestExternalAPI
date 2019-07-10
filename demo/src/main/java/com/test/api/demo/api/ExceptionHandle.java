package com.test.api.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.test.api.demo.exception.InvalidException;
import com.test.api.demo.exception.TestApiException;
import com.test.api.demo.response.ApiResponse;
import com.test.api.demo.util.Const;

@ControllerAdvice
@RestController
public class ExceptionHandle {

	@ExceptionHandler(TestApiException.class)
	public ResponseEntity<? extends ApiResponse> handleNotFound(TestApiException ex) {
		ApiResponse res = new ApiResponse();
		res.setType(ex.getTypeCode());
		res.setMessage(ex.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<? extends ApiResponse> handleNotFound(InvalidException ex) {
		ApiResponse res = new ApiResponse();
		res.setType(ex.getTypeCode());
		res.setMessage(ex.getMessage());
		return new ResponseEntity<>(res, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<? extends ApiResponse> handleBadRequest(NoHandlerFoundException ex) {
		ApiResponse res = new ApiResponse();
		res.setType(Const.BAD_REQUEST_CODE);
		res.setMessage(Const.BAD_REQUEST_MESSAGE);
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<? extends ApiResponse> handleErr(Exception ex) {
		ApiResponse res = new ApiResponse();
		res.setType(Const.INTERNAL_ERROR_CODE);
		res.setMessage(Const.INTERNAL_ERROR_MESSAGE);
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
	
}
