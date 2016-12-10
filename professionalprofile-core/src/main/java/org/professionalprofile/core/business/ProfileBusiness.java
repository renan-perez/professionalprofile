package org.professionalprofile.core.business;

import org.professionalprofile.core.dao.LanguageDAO;
import org.professionalprofile.core.dao.ProfileDAO;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileBusiness {

    @Autowired
    private ProfileDAO profileDAO;
    @Autowired
    private LanguageDAO languageDAO;

    public Profile getMainProfile() throws SystemException {
        return profileDAO.getMainProfile();
    }

    public Profile getProfileByLanguage(Language language) throws SystemException {
        return profileDAO.getProfileByLanguage(language);
    }

    public List<Language> listAvailableProfileLanguages() throws SystemException {
        return languageDAO.listAvailableProfileLanguages();
    }

}
