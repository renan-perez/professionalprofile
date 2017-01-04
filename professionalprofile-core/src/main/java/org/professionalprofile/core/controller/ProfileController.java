package org.professionalprofile.core.controller;

import java.util.List;

import org.professionalprofile.core.business.ProfileBusiness;
import org.professionalprofile.core.exception.SystemException;
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

    @RequestMapping(value = "/getProfileMainInformation", method = RequestMethod.GET)
    public Profile getMainInformation(Integer userId) {
        try {
            return profileBusiness.getMainInformation(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/getUserSkills", method = RequestMethod.GET)
    public List<Skill> getUserSkills(Integer userId) {
    	try {
            return profileBusiness.getUserSkills(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
