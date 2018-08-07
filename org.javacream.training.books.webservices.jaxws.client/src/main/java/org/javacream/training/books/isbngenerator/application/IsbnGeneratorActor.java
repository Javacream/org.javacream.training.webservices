package org.javacream.training.books.isbngenerator.application;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public class IsbnGeneratorActor {

	private IsbnGenerator isbnGenerator;

	
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}


	public void act() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			isbnGenerator.next();
		}
		System.out.println("Retrieving 100 isbns took " + (System.currentTimeMillis() - start));

		
		
	}
}
