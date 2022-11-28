package com.rebel.blogJwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import com.rebel.blogJwt.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalException 
{
	
	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<ApiResponse> getExce(ResourceAccessException ex)
	{
		String message = ex.getMessage();
		ApiResponse api = new ApiResponse(message, false);
		
		return new ResponseEntity<ApiResponse>(api, HttpStatus.OK );
	}

  
}