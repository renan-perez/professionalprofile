package org.professionalprofile.core.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Experience;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceDAO extends GenericDAO<Experience, Integer> {
	
	public Experience getNewestExperience() throws SystemException {
		return super.getByNamedQuery("Experience.getNewestExperience", null, Experience.class);
	}
	
	public Experience getNewerExperience(LocalDate inicialDate) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("inicialDate", inicialDate);
		return super.getByNamedQuery("Experience.getNewerExperience", paramValueMap, Experience.class);
	}
	
	public Experience getOldestExperience() throws SystemException {
		return super.getByNamedQuery("Experience.getOldestExperience", null, Experience.class);
	}
	
	public Experience getOlderExperience(LocalDate inicialDate) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("inicialDate", inicialDate);
		return super.getByNamedQuery("Experience.getOlderExperience", paramValueMap, Experience.class);
	}
	
	
	
}
