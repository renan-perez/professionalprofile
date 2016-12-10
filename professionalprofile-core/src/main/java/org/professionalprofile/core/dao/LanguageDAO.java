package org.professionalprofile.core.dao;

import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageDAO extends GenericDAO<Language, Integer> {

    public List<Language> listAvailableProfileLanguages() throws SystemException {
        return (List<Language>) listByNamedQuery("Profile.listAvailableProfileLanguages", null, Language.class);
    }

}
