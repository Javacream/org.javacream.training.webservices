package org.javacream.training.webservices.store;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javacream.store.StoreService;
import org.javacream.util.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("api")
public class OptimizedStoreWebService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("store/{category}")
	public List<Integer> getStocks(@PathParam("category") String category, List<String> ids) {
		System.out.println("retrieving stock for category" + category + " and ids" + ids);
		StoreService storeService = ApplicationContext.getStoreService();
		return ids.stream().map((id) -> storeService.getStock(category, id)).collect(Collectors.toList());
	}
}
