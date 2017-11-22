package com.kalphix.wea.config;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(javax.ws.rs.Priorities.AUTHENTICATION)
public class BasicAuthenticationProvider implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		if (authenticate(requestContext)) {
			// îFèÿê¨å˜
			return;
		}

		// îFèÿé∏îs
		Response response = Response.status(Status.UNAUTHORIZED).build();
		requestContext.abortWith(response);
	}

	private boolean authenticate(ContainerRequestContext requestContext) {
		//requestContext.getHeaderString("WOPUSERINFO");
		return true;
	}

}