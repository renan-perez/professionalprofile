package org.professionalprofile.core.business;

import java.time.LocalDate;
import java.util.List;

import org.professionalprofile.core.dao.ContactDAO;
import org.professionalprofile.core.dao.EducationDAO;
import org.professionalprofile.core.dao.ExperienceDAO;
import org.professionalprofile.core.dao.ImageDAO;
import org.professionalprofile.core.dao.LanguageDAO;
import org.professionalprofile.core.dao.ProfileDAO;
import org.professionalprofile.core.dao.SkillsDAO;
import org.professionalprofile.core.enums.Age;
import org.professionalprofile.core.enums.ContactType;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Contact;
import org.professionalprofile.core.model.Education;
import org.professionalprofile.core.model.Experience;
import org.professionalprofile.core.model.Image;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.Skill;
import org.professionalprofile.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileBusiness {

    @Autowired private LanguageDAO languageDAO;
    @Autowired private ContactDAO contactDAO;
    @Autowired private ProfileDAO profileDAO;
    @Autowired private SkillsDAO skillsDAO;
    @Autowired private EducationDAO educationDAO;
    @Autowired private ExperienceDAO experienceDAO;
    @Autowired private ImageDAO imageDAO;

    public Profile getMainInformation(final Integer userId, final Language language) throws SystemException {
    	Boolean mainProfile = language == null ? true : null; //When language == null, find main profile
    	Contact contact = contactDAO.getMainContact(userId);
        Profile profile = profileDAO.getMainProfile(userId, language, mainProfile);
        profile.setMainContact(contact);
        return profile;
    }
    
    public Image getUserPhoto(final Integer userId) throws SystemException {
    	return imageDAO.getUserPhoto(userId);
    }

    public Profile getProfileByLanguage(final Integer userId, final Language language) throws SystemException {
        return profileDAO.getProfileByLanguage(userId, language);
    }

    public List<Language> listAvailableProfileLanguages() throws SystemException {
        return languageDAO.listAvailableProfileLanguages();
    }
    
    public List<Skill> listUserSkills(Integer userId) throws SystemException {
    	return skillsDAO.listUserSkills(userId);
    }
    
    public List<Education> listUserEducation(final Integer userId, final Language language) throws SystemException {
    	List<Education> userEducationList = educationDAO.listUserEducation(userId, language);
    	//Calculate period in years and months
    	userEducationList.forEach(education -> {
    		education.setYears(DateUtil.periodInYears(education.getInitialDate(), education.getFinalDate()));
    		education.setMonths(DateUtil.periodInMonths(education.getInitialDate(), education.getFinalDate()));
    	});
    	return userEducationList;
    }
    
    public List<Contact> listUserSocialNetworks(final Integer userId) throws SystemException {
    	return contactDAO.listUserContactByType(userId, ContactType.listSocialNetworkTypes());
    }
    
    public Experience getExperience(final LocalDate inicialDate, Age age) throws SystemException {
    	Experience experience = null;
    	int tryNumber = 2;
    	do {
    		experience = experienceDAO.getExperience(inicialDate, age);
    		
	    	switch (age) {
			case OLDER:
				age = Age.NEWEST;
				break;
			default:
				age = Age.OLDEST;
			}
	    	
	    	tryNumber -= 1;
	    	
    	} while(experience == null && tryNumber > 0);
    	
    	if (experience != null) {
    		experience.setYears(DateUtil.periodInYears(experience.getInitialDate(), experience.getFinalDate()));
    		experience.setMonths(DateUtil.periodInMonths(experience.getInitialDate(), experience.getFinalDate()));
    	}
    	
    	return experience;
    }

}
