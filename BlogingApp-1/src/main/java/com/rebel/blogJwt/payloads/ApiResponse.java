package com.rebel.blogJwt.payloads;

public class ApiResponse 
{
	String Message = "";
	
	boolean Success;

	public ApiResponse() {
		super();
	}

	public ApiResponse(String message, boolean success) {
		super();
		Message = message;
		Success = success;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}
	
	

}
