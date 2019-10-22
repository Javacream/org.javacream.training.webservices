package org.javacream.training.webservices.idgenerator;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("api")
public class SequenceIdGenerator {

	private long counter = 0;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("id")
	public long nextId() {
		return counter++;
	}
}
