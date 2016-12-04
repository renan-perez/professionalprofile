package org.professionalprofile.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.*;

public abstract class GenericDAO<T, ID extends Serializable> implements GenericPersistence<T, ID> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public T save(final T instance) {
        manager.persist(instance);
        manager.flush();
        return instance;
    }

    @Override
    public void delete(T t) {
        manager.remove(t);
        manager.flush();
    }

    @Override
    public T get(final Class<T> clazz, final ID id) {
        return manager.find(clazz, id);
    }

    @Override
    public List<T> list(final Class<T> clazz) {
        return listByNamedQuery(clazz.getName() + ".list", null, clazz);
    }

    @Override
    public List<T> listByNamedQuery(final String namedQuery, final Map<String, Object> paramValue, final Class<T> clazz) {
        return createQuery(namedQuery, paramValue, clazz).getResultList();
    }

    @Override
    public T getByNamedQuery(final String namedQuery, final Map<String, Object> paramValue, final Class<T> clazz) {
        return (T) createQuery(namedQuery, paramValue, clazz).getSingleResult();
    }

    private Query createQuery(final String namedQuery, final Map<String, Object> paramValue, final Class<T> clazz) {
        Query query = manager.createNamedQuery(namedQuery, clazz);
        if (!Objects.isNull(paramValue))
            paramValue.forEach((name, param) -> query.setParameter(name, param));
        return query;
    }
}