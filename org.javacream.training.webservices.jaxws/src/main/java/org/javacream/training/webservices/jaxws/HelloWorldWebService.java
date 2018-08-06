package org.javacream.training.webservices.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloWorldWebService {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7890/hello", new HelloWorldWebService());
		System.out.println("Hello Web Service is ready!");
	}

	
	@WebMethod(exclude=false, operationName="SayHello")
	public @WebResult(name="HelloResponse") String sayHello() {
		System.out.println("Hello World!");
		return "Hello";
	}
}
