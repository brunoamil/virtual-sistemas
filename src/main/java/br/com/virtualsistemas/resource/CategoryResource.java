package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.model.Category;
import br.com.virtualsistemas.model.Response;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
@Component
@Path("/category")
public class CategoryResource implements CrudResource<Category> {

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    @Override
    public Response save(Category obj) throws Exception {
        return null;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    @Override
    public Response update(Category obj) throws Exception {
        return null;
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    @Override
    public Response delete(Category obj) throws Exception {
        return null;
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    @Override
    public List<Category> findAll() throws Exception {
        return null;
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    @Override
    public Category findByCode(Integer code) throws Exception {
        return null;
    }
}
