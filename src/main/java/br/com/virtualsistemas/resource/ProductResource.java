package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.dao.IProductDAO;
import br.com.virtualsistemas.facade.IFacade;
import br.com.virtualsistemas.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
@Component
@Path("/product")
public class ProductResource {

    @Autowired
    private IFacade facade;

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    public ResponseEntity save(@NotNull Product product) throws Exception {
        Product p = facade.get(IProductDAO.class).save(product);
        return ResponseEntity.ok(p);
    }

    @POST
    @Produces("application/json")
    @Path("/update")
    public ResponseEntity update(Product product) throws Exception {
        Product p = facade.get(IProductDAO.class).update(product);
        return ResponseEntity.ok(p);
    }


    @DELETE
    @Produces("application/json")
    @Path("/delete")
    public ResponseEntity delete(Product product) throws Exception {
        facade.get(IProductDAO.class).delete(product);
        return ResponseEntity.ok(String.format("Produto %d deletado com sucesso", product.getId()));
    }

    @GET
    @Produces("application/json")
    @Path("/all")
    public ResponseEntity<List<Product>> findAll() throws Exception {
        return ResponseEntity.ok(facade.get(IProductDAO.class).findAll());
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public ResponseEntity<?> findByCode(@PathParam("id") Integer code) throws Exception {
        try {
            return ResponseEntity.ok(facade.get(IProductDAO.class).findById(code));
        } catch (NoResultException ex) {
            return new ResponseEntity<Object>(String.format("O produto %d não foi encontrado",code), HttpStatus.OK);
        }
    }

}
