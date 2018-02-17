package br.com.virtualsistemas.dao;

import br.com.virtualsistemas.model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


@Repository
@Transactional
public class ProductDAO implements IProductDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Product save(Product obj) throws Exception {
        entityManager.unwrap(Session.class).save(obj);
        return obj;
    }

    @Override
    public Product update(Product obj) throws Exception {
        entityManager.unwrap(Session.class).update(obj);
        return obj;
    }

    @Override
    public void delete(Product obj) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        Object mergedObject = session.merge(obj);
        session.delete(mergedObject);
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
