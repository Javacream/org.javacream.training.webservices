package org.javacream.training.webservices.jaxws.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class HelloWorldWebService {

	@WebMethod(exclude=false, operationName="SayHello")
	public @WebResult(name="HelloResponse") String sayHello() {
		System.out.println("Hello World!");
		return "Hello";
	}

	@WebMethod(exclude=false, operationName="Greet")
	public @WebResult(name="GreetingMessage")String greet(@WebParam(name="PersonName") String name) {
		System.out.println("create greeting for " + name);
		return "Hello, " + name;
	}
}
