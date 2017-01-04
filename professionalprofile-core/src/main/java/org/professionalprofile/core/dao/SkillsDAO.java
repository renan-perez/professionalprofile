package org.professionalprofile.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Skill;
import org.springframework.stereotype.Repository;

@Repository
public class SkillsDAO extends GenericDAO<Skill, String> {
	
	public List<Skill> listUserSkills(Integer userId) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
		return (List<Skill>) super.listByNamedQuery("Skill.listUserSkills", paramValueMap, Skill.class);
	}
	
}
