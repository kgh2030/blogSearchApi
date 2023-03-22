package com.search.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.search.response.ReponseUtils;
import com.search.response.Response;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(Exception.class)
	public <T> Response<T> handleException(Exception e) {
		return ReponseUtils.error(e.getMessage());
	}
	
	@ExceptionHandler(BindException.class)
	public <T> Response<T> validException(BindException ex) {
		return ReponseUtils.fail(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), null, "local");
	}
	
	
	
}
