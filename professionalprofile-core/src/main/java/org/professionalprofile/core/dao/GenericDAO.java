package org.professionalprofile.core.dao;

import org.professionalprofile.core.exception.SystemException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.*;

@Repository
public class GenericDAO<T, ID extends Serializable> {

    @PersistenceContext
    private EntityManager manager;

    protected T save(final T instance) throws SystemException {
        manager.persist(instance);
        manager.flush();
        return instance;
    }

    protected void delete(T t) throws SystemException {
        manager.remove(t);
        manager.flush();
    }

    protected T get(final Class<T> clazz, final ID id) throws SystemException {
        return manager.find(clazz, id);
    }

    protected List<T> list(final Class<T> clazz) throws SystemException {
        return listByNamedQuery(clazz.getName() + ".list", null, clazz);
    }

    protected List<T> listByNamedQuery(final String namedQuery,
                                       final Map<String, Object> paramValueMap, final Class<T> clazz) throws SystemException {
        return createQuery(namedQuery, paramValueMap, clazz).getResultList();
    }

    protected T getByNamedQuery(final String namedQuery,
                                final Map<String, Object> paramValueMap, final Class<T> clazz) throws SystemException {
        return (T) createQuery(namedQuery, paramValueMap, clazz).getSingleResult();
    }

    private Query createQuery(final String namedQuery, final Map<String, Object> paramValueMap, final Class<T> clazz) {
        Query query = manager.createNamedQuery(namedQuery, clazz);
        if (!Objects.isNull(paramValueMap))
            paramValueMap.forEach((name, param) -> query.setParameter(name, param));
        return query;
    }
}