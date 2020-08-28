package org.javacream.training.webservices.util.web.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ContentTypePostMatchContainerResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext containerRequestContext,
			ContainerResponseContext containerResponseContext) throws IOException {
		System.out.println(containerResponseContext.getHeaders());
		System.out.println("Content-Type: " + containerResponseContext.getHeaderString("Content-Type"));
		System.out.println("Accept: " + containerResponseContext.getHeaderString("Accept"));
	}
}