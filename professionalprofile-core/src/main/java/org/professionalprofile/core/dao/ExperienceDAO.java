package org.professionalprofile.core.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.professionalprofile.core.enums.Age;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Experience;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceDAO extends GenericDAO<Experience, Integer> {
	
	public Experience getExperience(final LocalDate inicialDate, final Age age) throws SystemException {
		switch (age) {
    	case OLDER:
    		return this.getOlderExperience(inicialDate);
    	case OLDEST:
    		return this.getOldestExperience();
    	case NEWER:
    		return this.getNewerExperience(inicialDate);
		default:
			return this.getNewestExperience();
		}
	}
	
	public Experience getNewestExperience() throws SystemException {
		return super.getByNamedQuery("Experience.getNewestExperience", null, Experience.class);
	}
	
	public Experience getNewerExperience(final LocalDate inicialDate) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("inicialDate", inicialDate);
		return super.getByNamedQuery("Experience.getNewerExperience", paramValueMap, Experience.class);
	}
	
	public Experience getOldestExperience() throws SystemException {
		return super.getByNamedQuery("Experience.getOldestExperience", null, Experience.class);
	}
	
	public Experience getOlderExperience(final LocalDate inicialDate) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("inicialDate", inicialDate);
		return super.getByNamedQuery("Experience.getOlderExperience", paramValueMap, Experience.class);
	}
	
	
	
}
