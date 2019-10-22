package org.javacream.training.webservices.util.web.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@PreMatching
@Provider
public class DelayRequestPreMatchContainerRequestFilter implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext containerRequestContext)
			throws IOException {
		String delayString = containerRequestContext.getUriInfo()
				.getQueryParameters().getFirst("delay");
		System.out.println("Delaying request, delay=" + delayString);
		if (delayString != null) {
			long delay = Long.parseLong(delayString);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}