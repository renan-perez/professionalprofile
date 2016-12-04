package org.professionalprofile.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericPersistence<T, ID extends Serializable> {

    T save(final T instance);

    void delete(T t);

    T get(final Class<T> clazz, final ID id);

    List<T> list(final Class<T> clazz);

    T getByNamedQuery(final String namedQuery, final Map<String,Object> paramValue, final Class<T> clazz);

    List<T> listByNamedQuery(final String namedQuery, final Map<String,Object> paramValue, final Class<T> clazz);
}
