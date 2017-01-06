package org.professionalprofile.core.controller;

import java.time.LocalDate;
import java.util.List;

import org.professionalprofile.core.business.ProfileBusiness;
import org.professionalprofile.core.enums.Age;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Education;
import org.professionalprofile.core.model.Experience;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private ProfileBusiness profileBusiness;
    
    @RequestMapping(value = "/getProfileMainInformation/{userId}", method = RequestMethod.GET)
    public Profile getMainInformation(@PathVariable Integer userId) {
        try {
            return profileBusiness.getMainInformation(userId, null);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getProfileMainInformation/{userId}/{language}", method = RequestMethod.GET)
    public Profile getMainInformation(@PathVariable Integer userId, @PathVariable Language language) {
        try {
            return profileBusiness.getMainInformation(userId, language);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/listUserSkills/{userId}", method = RequestMethod.GET)
    public List<Skill> listUserSkills(@PathVariable Integer userId) {
    	try {
            return profileBusiness.listUserSkills(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/listUserEducation/{userId}/{language}", method = RequestMethod.GET)
    public List<Education> listUserEducation(@PathVariable Integer userId, @PathVariable Language language) {
    	try {
            return profileBusiness.listUserEducation(userId, language);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/getExperience/{userId}/{language}", method = RequestMethod.GET)
    public Experience getEducation(@PathVariable Integer userId, @PathVariable Language language, Age age, 
    			@RequestParam(name="initialDate", required=false) @DateTimeFormat(pattern = "yyyy,M,d") LocalDate inicialDate) {
    	try {
            return profileBusiness.getExperience(inicialDate, age);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
