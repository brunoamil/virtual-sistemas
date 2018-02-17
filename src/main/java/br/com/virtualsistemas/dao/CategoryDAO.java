package br.com.virtualsistemas.dao;

import br.com.virtualsistemas.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
@Repository
@Transactional
public class CategoryDAO implements ICategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category save(Category obj) throws Exception {
        entityManager.unwrap(Session.class).save(obj);
        return obj;
    }

    @Override
    public Category update(Category obj) throws Exception {
        entityManager.unwrap(Session.class).update(obj);
        return obj;
    }

    @Override
    public void delete(Category obj) throws Exception {
        Session session = entityManager.unwrap(Session.class);
        Object mergedObject = session.merge(obj);
        session.delete(mergedObject);
    }

    @Override
    public Category findById(Serializable id) throws Exception {
        return (Category) entityManager.createQuery("from Category c where c.id =:id").setParameter("id",id).getSingleResult();
    }

    @Override
    public List<Category> findAll() throws Exception {
        return entityManager.createQuery("from Category").getResultList();
    }

    @Override
    public List<Category> findByParent(Integer parentID) throws Exception {
        return entityManager.createQuery("from Category c where c.categoryParent.id=:id").setParameter("id",parentID).getResultList();
    }
}
