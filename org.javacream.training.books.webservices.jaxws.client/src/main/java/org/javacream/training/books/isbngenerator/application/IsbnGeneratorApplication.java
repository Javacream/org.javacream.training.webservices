package org.javacream.training.books.isbngenerator.application;

import org.javacream.training.books.isbngenerator.webservices.jaxws.client.IsbnGeneratorWebServiceService;

public class IsbnGeneratorApplication {

	public static void main(String[] args) {
		IsbnGeneratorActor actor = new IsbnGeneratorActor();
		IsbnGeneratorAdapter adapter = new IsbnGeneratorAdapter();
		adapter.setIsbnGeneratorWebService(new IsbnGeneratorWebServiceService().getIsbnGeneratorWebServicePort());
		actor.setIsbnGenerator(adapter);
//		actor.setIsbnGenerator(Context.getIsbnGenerator());
		actor.act();
	}
}
