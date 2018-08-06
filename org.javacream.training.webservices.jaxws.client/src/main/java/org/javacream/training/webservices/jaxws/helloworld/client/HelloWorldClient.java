package org.javacream.training.webservices.jaxws.helloworld.client;


public class HelloWorldClient {

	public static void main(String[] args) {
		HelloWorldWebService service = new HelloWorldWebServiceService().getHelloWorldWebServicePort();
		String message = service.sayHello();
		System.out.println(message);
		String greeting = service.greet("Sawitzki");
		System.out.println(greeting);
	}

}
