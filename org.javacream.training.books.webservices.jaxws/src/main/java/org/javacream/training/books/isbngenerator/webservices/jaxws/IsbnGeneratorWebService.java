package org.javacream.training.books.isbngenerator.webservices.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

@WebService
public class IsbnGeneratorWebService {// implements IsbnGenerator{

	private IsbnGenerator isbnGenerator;

	@WebMethod(exclude = true)
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	@WebMethod(exclude = false, operationName = "Next")
	public @WebResult(name = "GeneratedIsbns") List<String> next(int fetchSize) {
		List<String> isbns = new ArrayList<>();
		for (int i = 0; i < fetchSize; i++) {
			isbns.add(isbnGenerator.next());
		}
		return isbns;
	}

}
