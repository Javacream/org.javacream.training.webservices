package org.javacream.training.webservices.jaxws;

import javax.xml.ws.Endpoint;

import org.javacream.training.webservices.jaxws.greeter.GreeterWebService;
import org.javacream.training.webservices.jaxws.helloworld.HelloWorldWebService;
import org.javacream.training.webservices.jaxws.postalcodes.PostalCodeWebService;

public class WebServiceServer {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7890/hello", new HelloWorldWebService());
		Endpoint.publish("http://localhost:7890/greeter", new GreeterWebService());
		Endpoint.publish("http://localhost:7890/pc", new PostalCodeWebService());
		System.out.println("Services are ready!");
	}

}
