package org.professionalprofile.core.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.professionalprofile.core.enums.Age;
import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Experience;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceDAO extends GenericDAO<Experience, Integer> {
	
	public Experience getExperience(final Integer userId, final LocalDate inicialDate, final Language langague, final Age age) throws SystemException {
		switch (age) {
    	case OLDER:
    		return this.getOlderExperience(userId, inicialDate);
    	case OLDEST:
    		return this.getOldestExperience(userId);
    	case NEWER:
    		return this.getNewerExperience(userId, inicialDate);
		default:
			return this.getNewestExperience(userId);
		}
	}
	
	public Experience getNewestExperience(final Integer userId) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
		return super.getByNamedQuery("Experience.getNewestExperience", paramValueMap, Experience.class);
	}
	
	public Experience getNewerExperience(final Integer userId, final LocalDate inicialDate) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
		paramValueMap.put("userId", userId);
        paramValueMap.put("inicialDate", inicialDate);
		return super.getByNamedQuery("Experience.getNewerExperience", paramValueMap, Experience.class);
	}
	
	public Experience getOldestExperience(final Integer userId) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
		return super.getByNamedQuery("Experience.getOldestExperience", paramValueMap, Experience.class);
	}
	
	public Experience getOlderExperience(final Integer userId, final LocalDate inicialDate) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
		paramValueMap.put("userId", userId);
        paramValueMap.put("inicialDate", inicialDate);
		return super.getByNamedQuery("Experience.getOlderExperience", paramValueMap, Experience.class);
	}
	
	
	
}
