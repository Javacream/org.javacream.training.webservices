package org.javacream.util.web.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ContentTypePostMatchContainerRequestFilter implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext containerRequestContext)
			throws IOException {
		System.out.println(containerRequestContext.getHeaders());
		System.out.println("Content-Type: " + containerRequestContext.getHeaderString("Content-Type"));
		System.out.println("Accept: " + containerRequestContext.getHeaderString("Accept"));
	}
}