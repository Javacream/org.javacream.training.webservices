package org.javacream.training.store.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javacream.ApplicationContext;
import org.javacream.store.api.StoreService;
import org.springframework.stereotype.Component;

@Component
@Path("api/store")
public class StoreWebService {

	private StoreService storeService = ApplicationContext.getStoreService();

	@GET
	@Path("{category}/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public int getStockPlain(@PathParam("category") String cat, @PathParam("id") String id) {
		return storeService.getStock(cat, id);
	}
	@GET
	@Path("{category}/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String getStockHtml(@PathParam("category") String cat, @PathParam("id") String id) {
		return "<p>"+storeService.getStock(cat, id)+"<p>";
	}
}
