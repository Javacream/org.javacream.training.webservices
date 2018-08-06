package org.javacream.training.webservices.jaxws;

import javax.xml.ws.Endpoint;

import org.javacream.training.webservices.jaxws.helloworld.HelloWorldWebService;

public class WebServiceServer {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7890/hello", new HelloWorldWebService());
		System.out.println("Services are ready!");
	}

}
