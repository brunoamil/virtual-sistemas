package br.com.virtualsistemas.resource;

import br.com.virtualsistemas.model.Response;

import java.util.List;

/**
 * Created by markiing on 16/02/18.
 */
public interface CrudResource<T> {

    Response save(T obj) throws Exception;
    Response update(T obj) throws Exception;
    Response delete(T obj) throws  Exception;
    List<T> findAll() throws Exception;
    T findByCode(Integer code) throws Exception;

}
