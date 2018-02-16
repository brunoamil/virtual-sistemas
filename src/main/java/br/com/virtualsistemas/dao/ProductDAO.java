package br.com.virtualsistemas.dao;

import br.com.virtualsistemas.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;


@Repository
public class ProductDAO implements IProductDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Product save(Product obj) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public Product update(Product obj) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(Product obj) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public Product findById(Serializable id) throws Exception {
        return (Product) entityManager.createQuery("from Product p where p.id =:id").setParameter("id",id).getSingleResult();
    }

    @Override
    public List<Product> findAll() throws Exception {
        return entityManager.createQuery("from Product").getResultList();
    }
}
