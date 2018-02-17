package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.dao.ICategoryDAO;
import br.com.virtualsistemas.dao.IProductDAO;
import br.com.virtualsistemas.facade.IFacade;
import br.com.virtualsistemas.model.Category;
import br.com.virtualsistemas.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
@Component
@Path("/category")
public class CategoryResource{

    @Autowired
    private IFacade facade;

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/save")
    public ResponseEntity save(Category obj) throws Exception {
        Category p = facade.get(ICategoryDAO.class).save(obj);
        return ResponseEntity.ok(String.format("Categoria %s inserida com sucesso", p.getName()));
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/update")
    public ResponseEntity update(Category obj) throws Exception {
        Category p = facade.get(ICategoryDAO.class).update(obj);
        return ResponseEntity.ok(String.format("Categoria %s alterada com sucesso", p.getName()));
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/delete")
    public ResponseEntity<String> delete(Category obj) throws Exception {
        facade.get(ICategoryDAO.class).delete(obj);
        return ResponseEntity.ok(String.format("Categoria %s deletada com sucesso", obj.getName()));
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/all")
    public List<Category> findAll() throws Exception {
        return facade.get(ICategoryDAO.class).findAll();
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    public ResponseEntity findByCode(@PathParam("id") Integer code) throws Exception {
        try {
            return ResponseEntity.ok(facade.get(ICategoryDAO.class).findById(code));
        } catch (NoResultException ex) {
            return new ResponseEntity<Object>(String.format("A categoria %d não foi encontrada",code), HttpStatus.OK);
        }
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/parent/{parentCode}")
    public ResponseEntity findByParent(@PathParam("parentCode") Integer parentCode) throws Exception {
        try {
            return ResponseEntity.ok(facade.get(ICategoryDAO.class).findByParent(parentCode));
        } catch (NoResultException ex) {
            return new ResponseEntity<Object>(String.format("A categoria pai %d não foi encontrado",parentCode), HttpStatus.OK);
        }
    }
}
