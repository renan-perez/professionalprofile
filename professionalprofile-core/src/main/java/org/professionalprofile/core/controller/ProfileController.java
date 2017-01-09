package org.professionalprofile.core.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.professionalprofile.core.business.ProfileBusiness;
import org.professionalprofile.core.enums.Age;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Contact;
import org.professionalprofile.core.model.Education;
import org.professionalprofile.core.model.Experience;
import org.professionalprofile.core.model.Image;
import org.professionalprofile.core.model.Profile;
import org.professionalprofile.core.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
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
    
    @RequestMapping(value = "/getUserPhoto/{userId}")
    public void getUserPhoto(@PathVariable Integer userId, HttpServletResponse response) {
    	try {
    		Image photo = profileBusiness.getUserPhoto(userId);
		   response.setContentType(MediaType.IMAGE_PNG_VALUE);
		   response.getOutputStream().write(photo.getContent());
        } catch (SystemException | IOException e) {
            e.printStackTrace();
        }
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
    
    @RequestMapping(value = "/listUserEducation/{userId}", method = RequestMethod.GET)
    public List<Education> listUserEducation(@PathVariable Integer userId, Language language) {
    	try {
            return profileBusiness.listUserEducation(userId, language);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/getExperience/{userId}", method = RequestMethod.GET)
    public Experience getEducation(@PathVariable Integer userId, Language language, Age age, 
    			@RequestParam(name="initialDate", required=false) @DateTimeFormat(pattern = "yyyy,M,d") LocalDate inicialDate) {
    	try {
            return profileBusiness.getExperience(userId, inicialDate, language, age);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/listUserSocialNetworks/{userId}", method = RequestMethod.GET)
    public List<Contact> listUserSocialNetworks(@PathVariable Integer userId) {
    	try {
            return profileBusiness.listUserSocialNetworks(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
