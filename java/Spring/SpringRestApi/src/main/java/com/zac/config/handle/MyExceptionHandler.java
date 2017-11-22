package com.zac.config.handle;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.zac.com.BizException;
import com.zac.com.dto.ErrorResponse;
import com.zac.config.message.BundleMessageSource;

@ControllerAdvice
public class MyExceptionHandler {

	@Autowired
	private BundleMessageSource messageSource;

	/** Logger */
	private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<ErrorResponse> exceptionHandler(Exception exception, HttpServletRequest request) {

		// URI
		String uri = request.getRequestURI();
		String msg = "";

		if (exception instanceof BizException) {
			msg = String.format("BizException occured when accessing [%s]. %s", uri, exception.getMessage());
			logger.warn(msg);

			String bizErrorCode = ((BizException) exception).getBizErrorCode();
			ErrorResponse errResponse = messageSource.getBizErrorResponse(bizErrorCode);

			return new ResponseEntity<ErrorResponse>(errResponse, errResponse.getStatus());
		}
		
		if (exception instanceof NoHandlerFoundException) {
			msg = String.format("NoHandlerFoundException occured when accessing [%s]. %s", uri, exception.getMessage());
			logger.warn(msg);

			ErrorResponse errResponse = new ErrorResponse();
			errResponse.setStatus(HttpStatus.NOT_FOUND);
			errResponse.setError(HttpStatus.NOT_FOUND.name());
			errResponse.setError_description(HttpStatus.NOT_FOUND.getReasonPhrase());

			return new ResponseEntity<ErrorResponse>(errResponse, errResponse.getStatus());
		}

		

		msg = String.format(
				"Unknown Exception occured when accessing [%s], response will return INTERNAL_SERVER_ERROR[500].", uri);
		logger.error(msg, exception);

		ErrorResponse errResponse = new ErrorResponse();
		errResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		errResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
		errResponse.setError_description(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		return new ResponseEntity<ErrorResponse>(errResponse, errResponse.getStatus());
	}
}
