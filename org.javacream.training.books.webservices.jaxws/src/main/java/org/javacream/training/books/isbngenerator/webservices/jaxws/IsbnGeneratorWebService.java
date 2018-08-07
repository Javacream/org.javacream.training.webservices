package org.javacream.training.books.isbngenerator.webservices.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

@WebService
public class IsbnGeneratorWebService{// implements IsbnGenerator{

	
	private IsbnGenerator isbnGenerator;

	@WebMethod(exclude=true)
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	@WebMethod(exclude=false, operationName="Next")
	public @WebResult(name="GeneratedIsbn")String next() {
		return isbnGenerator.next();
	}

}
