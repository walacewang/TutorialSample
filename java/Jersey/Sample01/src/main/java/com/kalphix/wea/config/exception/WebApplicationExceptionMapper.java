package com.kalphix.wea.config.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException ex) {
		//return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
		ErrorResult errorResult = new ErrorResult();
		errorResult.setStatus("401");
		errorResult.setErrorCode("WEA0101");
		errorResult.setErrorMessage("要求データ不正です。");
		return Response.status(401).entity(errorResult).type(MediaType.APPLICATION_JSON).build();

	}
}