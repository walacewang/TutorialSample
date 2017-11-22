package com.zac.com.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorResponse {
	@JsonIgnore
	private HttpStatus status;
	private String error;
	private String error_description;

	public ErrorResponse(HttpStatus status) {
		this.status = status;
	}

	public ErrorResponse() {
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

}
