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

    public Profile getMainProfile(final Integer userId, final Language language, final Boolean mainProfile) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
        paramValueMap.put("language", language);
        paramValueMap.put("mainProfile", mainProfile);
        return super.getByNamedQuery("Profile.getMainInformation", paramValueMap, Profile.class);
    }

    public Profile getProfileByLanguage(final Integer userId, final Language language) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("language", language);
        paramValueMap.put("userId", userId);
        return super.getByNamedQuery("Profile.getByLanguage", paramValueMap, Profile.class);
    }

}
