package org.professionalprofile.core.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.professionalprofile.core.exception.SystemException;
import org.springframework.stereotype.Repository;

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

    protected Collection<T> list(final Class<T> clazz) throws SystemException {
        return listByNamedQuery(clazz.getName() + ".list", null, clazz);
    }

    @SuppressWarnings("unchecked")
	protected Collection<T> listByNamedQuery(final String namedQuery,
                                       final Map<String, Object> paramValueMap, final Class<T> clazz) throws SystemException {
        return createQuery(namedQuery, paramValueMap, clazz).getResultList();
    }
    
    @SuppressWarnings("unchecked")
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