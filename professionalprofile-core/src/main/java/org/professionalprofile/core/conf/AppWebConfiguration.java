package org.professionalprofile.core.conf;

import java.text.SimpleDateFormat;

import org.professionalprofile.core.business.ProfileBusiness;
import org.professionalprofile.core.controller.HomeController;
import org.professionalprofile.core.controller.ProfileController;
import org.professionalprofile.core.dao.ContactDAO;
import org.professionalprofile.core.dao.GenericDAO;
import org.professionalprofile.core.dao.LanguageDAO;
import org.professionalprofile.core.dao.ProfileDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProfileController.class, ProfileBusiness.class,
        ProfileDAO.class, GenericDAO.class, LanguageDAO.class, ContactDAO.class})
public class AppWebConfiguration {
	
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
		b.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy,MM,dd"));
		return b;
	}
}
