package org.professionalprofile.core.business;

import java.math.BigInteger;
import java.util.List;

import org.professionalprofile.core.dao.ContactDAO;
import org.professionalprofile.core.dao.LanguageDAO;
import org.professionalprofile.core.dao.ProfileDAO;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Contact;
import org.professionalprofile.core.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileBusiness {

    @Autowired private LanguageDAO languageDAO;
    @Autowired private ContactDAO contactDAO;
    @Autowired private ProfileDAO profileDAO;

    public Profile getMainInformation(BigInteger userId) throws SystemException {
        Contact contact = contactDAO.getMainContact(userId);
        Profile profile = profileDAO.getMainProfile(userId);
        profile.setMainContact(contact);
        return profile;
    }

    public Profile getProfileByLanguage(BigInteger userId, Language language) throws SystemException {
        return profileDAO.getProfileByLanguage(userId, language);
    }

    public List<Language> listAvailableProfileLanguages() throws SystemException {
        return languageDAO.listAvailableProfileLanguages();
    }

}
