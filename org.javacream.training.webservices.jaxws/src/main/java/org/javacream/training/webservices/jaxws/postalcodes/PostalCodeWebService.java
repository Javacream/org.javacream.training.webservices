package org.javacream.training.webservices.jaxws.postalcodes;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class PostalCodeWebService {

	private Map<String, PostalCode> codes;
	
	{
		codes = new HashMap<>();
		codes.put("München", new PostalCode(81377, "München"));
		
	}
	
	@WebMethod(exclude=false, operationName="FindByCity")
	public @WebResult(name="PostalCode")PostalCode findByCity(@WebParam(name="City", header=true)String city) {
		return codes.get(city);
	}
}
