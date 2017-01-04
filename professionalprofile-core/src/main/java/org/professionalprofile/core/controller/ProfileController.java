package org.professionalprofile.core.controller;

import java.util.List;

import org.professionalprofile.core.business.ProfileBusiness;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Education;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private ProfileBusiness profileBusiness;

    @RequestMapping(value = "/listProfileMainInformation", method = RequestMethod.GET)
    public Profile getMainInformation(Integer userId) {
        try {
            return profileBusiness.getMainInformation(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/listUserSkills", method = RequestMethod.GET)
    public List<Skill> listUserSkills(Integer userId) {
    	try {
            return profileBusiness.listUserSkills(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/listUserEducation", method = RequestMethod.GET)
    public List<Education> listUserEducation(Integer userId, Language language) {
    	try {
            return profileBusiness.listUserEducation(userId, language);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
