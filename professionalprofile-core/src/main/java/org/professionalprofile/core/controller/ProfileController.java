package org.professionalprofile.core.controller;

import java.math.BigInteger;

import org.professionalprofile.core.business.ProfileBusiness;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private ProfileBusiness profileBusiness;

    @RequestMapping(value = "/getProfileMainInformation", method = RequestMethod.GET)
    public Profile getMainInformation(BigInteger userId) {
        try {
            return profileBusiness.getMainInformation(userId);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

}
