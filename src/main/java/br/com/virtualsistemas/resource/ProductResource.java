package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.dao.IProductDAO;
import br.com.virtualsistemas.facade.IFacade;
import br.com.virtualsistemas.model.Product;
import br.com.virtualsistemas.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
@Component
@Path("/product")
public class ProductResource implements CrudResource<Product> {

    @Autowired
    private IFacade facade;

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    @Override
    public Response save(@NotNull Product product) throws Exception {
        Product p = facade.get(IProductDAO.class).save(product);
        return new Response(HttpStatus.OK, String.format("Produto de id %d inserido com sucesso", p.getId()));
    }

    @POST
    @Produces("application/json")
    @Path("/update")
    public Response update(Product product) throws Exception {
        Product p = facade.get(IProductDAO.class).update(product);
        return new Response(HttpStatus.OK,String.format("Produto %d alterado com sucesso",p.getId()));
    }


    @DELETE
    @Produces("application/json")
    @Path("/delete")
    public Response delete(Product product) throws Exception {
        facade.get(IProductDAO.class).delete(product);
        return new Response(HttpStatus.OK,String.format("Produto %d deletado com sucesso",product.getId()));
    }

    @GET
    @Produces("application/json")
    @Path("/all")
    @Override
    public List<Product> findAll() throws Exception {
        return facade.get(IProductDAO.class).findAll();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    @Override
    public Product findByCode(Integer code) throws Exception {
        return facade.get(IProductDAO.class).findById(code);
    }

}
