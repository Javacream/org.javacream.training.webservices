package org.javacream.training.webservices.jaxws.greeter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class GreeterWebService {
	@WebMethod(exclude=false, operationName="Greet")
	public @WebResult(name="GreetingMessage")String greet(@WebParam(name="Name") String name) {
		System.out.println("create greeting for " + name);
		return "Hello, " + name;
	}
	
	
	@WebMethod(exclude=false, operationName="GreetFriendly")
	public @WebResult(name="GreetingFriendlyMessage")String greetFriendly(@WebParam(name="Name") String name, @WebParam(name="Friendly") boolean isFriendly) {
		System.out.println("create greeting for " + name +", friendly = " + isFriendly);
		if(isFriendly) {
			return "Hello, " + name + ", nice to greet you!";
		}
		return "Hello, " + name;
		
	}
	

}
