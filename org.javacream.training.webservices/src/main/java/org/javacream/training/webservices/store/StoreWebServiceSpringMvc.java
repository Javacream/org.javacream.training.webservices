package org.javacream.training.webservices.store;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.javacream.store.StoreService;
import org.javacream.util.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreWebServiceSpringMvc {

	private StoreService storeService = new LoggingStoreService(ApplicationContext.getStoreService());


	@GetMapping(path="api/spring/store/{c}/{i}")
	public int getStockWithPath(@PathVariable("c") String cat, @PathVariable("i") String id) {
		System.out.println("getStockWithPath");
		return storeService.getStock(cat, id);
	}

	@GET
	@Path("store/query")
	public int getStockWithQuery(@QueryParam("cat") String cat, @QueryParam("id") String id) {
		System.out.println("getStockWithQuery");
		return storeService.getStock(cat, id);
	}

	@GET
	@Path("store/header")
	public int getStockWithHeader(@HeaderParam("CATEGORY") String cat, @HeaderParam("ID") String id) {
		System.out.println("getStockWithHeader");
		return storeService.getStock(cat, id);
	}

	@GET
	@Path("store/{c}")
	public int getStockWithPathAndHeader(@PathParam("c") String cat, @HeaderParam("ID") String id) {
		System.out.println("getStockWithPathAndHeader");
		return storeService.getStock(cat, id);
	}


	private class LoggingStoreService implements StoreService{
		private StoreService storeService;
		public int getStock(String category, String item) {
			System.out.println("rtrieving stock for category=" + category + ", item=" + item);
			return storeService.getStock(category, item);
		}
		LoggingStoreService(StoreService storeService){
			this.storeService = storeService;
		}
	}
}
