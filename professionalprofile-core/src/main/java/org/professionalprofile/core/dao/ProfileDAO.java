package org.professionalprofile.core.dao;

import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.ProfileId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProfileDAO extends GenericDAO<Profile, ProfileId> {

    public Profile getMainProfile() throws SystemException {
        return getByNamedQuery("Profile.getMainProfilel",null, Profile.class);
    }

    public Profile getProfileByLanguage(Language language) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("language", language);
        return getByNamedQuery("Profile.getByLanguage", paramValueMap, Profile.class);
    }

}
