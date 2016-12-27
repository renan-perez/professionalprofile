package org.professionalprofile.core.dao;

import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.ProfileId;
import org.professionalprofile.core.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ProfileDAO {

    @PersistenceContext
    private EntityManager manager;

    public Profile getMainProfile(BigInteger userId) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
        return this.getByNamedQuery("Profile.getMainProfile", paramValueMap, Profile.class);
    }

    public Profile getProfileByLanguage(BigInteger userId, Language language) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("language", language);
        paramValueMap.put("userId", userId);
        return this.getByNamedQuery("Profile.getByLanguage", paramValueMap, Profile.class);
    }

    protected Profile getByNamedQuery(final String namedQuery,
                                final Map<String, Object> paramValueMap, final Class clazz) throws SystemException {
        return (Profile) createQuery(namedQuery, paramValueMap, clazz).getSingleResult();
    }

    private Query createQuery(final String namedQuery, final Map<String, Object> paramValueMap, final Class clazz) {
        Query query = manager.createNamedQuery(namedQuery, clazz);
        if (!Objects.isNull(paramValueMap))
            paramValueMap.forEach((name, param) -> query.setParameter(name, param));
        return query;
    }

}
