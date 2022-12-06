package com.ty.employee.response.dto;

public class ResponseDTO {

	private boolean isError;
	private String message;
	private Object object;

	public ResponseDTO(boolean isError, String message, Object object) {
		super();
		this.isError = isError;
		this.message = message;
		this.object = object;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
