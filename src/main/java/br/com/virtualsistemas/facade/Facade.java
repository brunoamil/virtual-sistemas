package br.com.virtualsistemas.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by markiing on 16/02/18.
 */
public class Facade implements IFacade {

    @Autowired
    private ApplicationContext context;

    @Override
    public <T> T get(Class<T> clazz) throws Exception {
        return context.getBean(clazz);
    }
}
