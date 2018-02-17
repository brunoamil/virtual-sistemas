package br.com.virtualsistemas.dao;


import br.com.virtualsistemas.model.Category;

import java.util.List;

public interface ICategoryDAO extends Crud<Category> {

    List<Category> findByParent(Integer parentID) throws Exception;

}
