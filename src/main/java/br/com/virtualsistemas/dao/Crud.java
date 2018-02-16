package br.com.virtualsistemas.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
public interface Crud<T> {
    T save(T obj) throws Exception;
    T update(T obj) throws Exception;
    void delete(T obj) throws Exception;
    T findById(Serializable id) throws Exception;
    List<T> findAll() throws Exception;
}
