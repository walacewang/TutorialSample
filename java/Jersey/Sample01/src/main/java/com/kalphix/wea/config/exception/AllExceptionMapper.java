package com.kalphix.wea.config.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AllExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception ex) {
		//return Response.status(500).entity(ex.getMessage()).type("text/plain").build();
		ErrorResult errorResult = new ErrorResult();
		errorResult.setStatus("500");
		errorResult.setErrorCode("WEA6501");
		errorResult.setErrorMessage("DB‚ÉÚ‘±‚·‚é‚ÉÚ‘±æ‚ª‚İ‚Â‚©‚ê‚Ü‚¹‚ñB");
		return Response.status(500).entity(errorResult).type(MediaType.APPLICATION_JSON).build();
	}
}