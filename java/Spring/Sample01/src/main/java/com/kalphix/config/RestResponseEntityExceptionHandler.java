package com.kalphix.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.kalphix.config.model.ExceptionResponse;
import com.kalphix.exception.BizException;

/**
 * 
 * @author kalphix
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler/* extends ResponseEntityExceptionHandler */ {

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex, WebRequest request) {

		ex.printStackTrace();
		if (ex instanceof BizException/* when special exception */) {
			BizException e = (BizException) ex;
			ExceptionResponse errorResult = new ExceptionResponse(HttpStatus.BAD_REQUEST);
			errorResult.setErrorCode(e.getBizErrorCode());
			errorResult.setErrorMessage(e.getBizErrorMessage());
			return new ResponseEntity<ExceptionResponse>(errorResult, HttpStatus.BAD_REQUEST);
		}

		// finally Exception
		ExceptionResponse errorResult = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResult.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(errorResult, HttpStatus.INTERNAL_SERVER_ERROR);

		// String bodyOfResponse = "This should be application specific";
		// return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
		// HttpStatus.CONFLICT, request);
	}
}
