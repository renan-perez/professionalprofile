package org.professionalprofile.core.controller;

import org.professionalprofile.core.model.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Profile home() {
        Profile p = new Profile();
        return p;
    }

}
