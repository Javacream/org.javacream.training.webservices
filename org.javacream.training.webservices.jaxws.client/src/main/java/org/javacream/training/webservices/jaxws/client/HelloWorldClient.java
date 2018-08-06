package org.javacream.training.webservices.jaxws.client;

public class HelloWorldClient {

	public static void main(String[] args) {
		HelloWorldWebService service = new HelloWorldWebServiceService().getHelloWorldWebServicePort();
		String message = service.sayHello();
		System.out.println(message);
	}

}
