package br.com.virtualsistemas.configuration;

import br.com.virtualsistemas.resource.ProductResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

/**
 * Created by markiing on 16/02/18.
 */
@Configuration
@ApplicationPath("/virtual-sistemas-api")
public class JerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void configuration(){
        register(ProductResource.class);
    }

}
