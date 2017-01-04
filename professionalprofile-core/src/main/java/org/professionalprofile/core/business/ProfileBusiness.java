package org.professionalprofile.core.business;

import java.util.List;

import org.professionalprofile.core.dao.ContactDAO;
import org.professionalprofile.core.dao.EducationDAO;
import org.professionalprofile.core.dao.LanguageDAO;
import org.professionalprofile.core.dao.ProfileDAO;
import org.professionalprofile.core.dao.SkillsDAO;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Contact;
import org.professionalprofile.core.model.Education;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileBusiness {

    @Autowired private LanguageDAO languageDAO;
    @Autowired private ContactDAO contactDAO;
    @Autowired private ProfileDAO profileDAO;
    @Autowired private SkillsDAO skillsDAO;
    @Autowired private EducationDAO educationDAO;

    public Profile getMainInformation(Integer userId) throws SystemException {
        Contact contact = contactDAO.getMainContact(userId);
        Profile profile = profileDAO.getMainProfile(userId);
        profile.setMainContact(contact);
        return profile;
    }

    public Profile getProfileByLanguage(Integer userId, Language language) throws SystemException {
        return profileDAO.getProfileByLanguage(userId, language);
    }

    public List<Language> listAvailableProfileLanguages() throws SystemException {
        return languageDAO.listAvailableProfileLanguages();
    }
    
    public List<Skill> listUserSkills(Integer userId) throws SystemException {
    	return skillsDAO.listUserSkills(userId);
    }
    
    public List<Education> listUserEducation(Integer userId, Language language) throws SystemException {
    	return educationDAO.listUserEducation(userId, language);
    }

}
