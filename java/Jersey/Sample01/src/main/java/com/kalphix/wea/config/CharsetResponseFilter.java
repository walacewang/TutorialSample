package com.kalphix.wea.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
public class CharsetResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		MediaType mediaType = responseContext.getMediaType();
		if (mediaType != null) {
			if (mediaType.equals(MediaType.APPLICATION_JSON_TYPE)) {
				responseContext.getHeaders().putSingle("Content-Type",
						new MediaType(mediaType.getType(), mediaType.getSubtype(), "UTF-8"));
			}
		}
	}
}