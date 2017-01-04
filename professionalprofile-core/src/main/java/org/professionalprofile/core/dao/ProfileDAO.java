package org.professionalprofile.core.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAO extends GenericDAO<Profile, Integer> {

    @PersistenceContext
    private EntityManager manager;

    public Profile getMainProfile(Integer userId) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
        return super.getByNamedQuery("Profile.getMainProfile", paramValueMap, Profile.class);
    }

    public Profile getProfileByLanguage(Integer userId, Language language) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("language", language);
        paramValueMap.put("userId", userId);
        return super.getByNamedQuery("Profile.getByLanguage", paramValueMap, Profile.class);
    }

}
