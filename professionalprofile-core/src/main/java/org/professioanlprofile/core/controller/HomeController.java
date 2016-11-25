package org.professioanlprofile.core.controller;

import org.org.professionalprofile.bean.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public Profile home() {
        Profile p = new Profile();
        p.setId(BigInteger.ONE);
        p.setOccupationArea("Information Technology");
        return p;
    }

}
