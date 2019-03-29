package org.javacream.training.webservices.jaxrs.spring;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@ApplicationPath("/api")
@EnableSwagger2
public class JerseyApplication extends ResourceConfig{
	public JerseyApplication() {
        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/api");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);
		
		packages(ApiListingResource.class.getPackage().getName(), "org.javacream.training.webservices.jaxrs", "org.javacream.training.books.rest", "org.javacream.training.store.rest", ApiListingResource.class.getPackage().getName());
	}
}



