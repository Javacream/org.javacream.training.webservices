package org.javacream.training.jaxrs.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("demo")
public class WebEcho {

	//Diese Methode soll aufgerufen werden bei einem GET-Request und Plain-Text liefern
	//Path für die Anwendung: "ping"
	//Aufruf-URL: GET http://localhost:8080/jee/rest/demo/ping
	
	@GET @Path("ping")
	public String ping() {
		return "pong";
	}

	//Aufruf-URL: GET http://localhost:8080/jee/rest/demo/echo/freitext
	
	@GET @Path("echo/{messageParam}")
	public String echo(@PathParam("messageParam")String message) {
		System.out.println("echoing " + message);
		return new StringBuilder(message).reverse().toString();
	}
}
