package br.com.virtualsistemas.facade;

/**
 * Created by markiing on 16/02/18.
 */
public interface IFacade {

    <T> T get(Class<T> clazz) throws Exception;
}
