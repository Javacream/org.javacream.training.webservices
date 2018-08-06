package org.javacream.training.webservices.jaxws.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class HelloWorldWebService {

	@WebMethod(exclude=false, operationName="SayHello")
	public @WebResult(name="HelloWorldResponse") String sayHello() {
		System.out.println("Hello World!");
		return "Hello";
	}

}
