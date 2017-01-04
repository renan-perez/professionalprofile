package org.professionalprofile.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.professionalprofile.core.enums.Language;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Education;
import org.springframework.stereotype.Repository;

@Repository
public class EducationDAO extends GenericDAO<Education, Integer> {
	
	public List<Education> listUserEducation(Integer userId, Language language) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
		paramValueMap.put("userId", userId);
		paramValueMap.put("language", language);
		return (List<Education>) super.listByNamedQuery("Education.listUserEducation", paramValueMap, Education.class);
	}
	
}
