package org.professionalprofile.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Image;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAO extends GenericDAO<Image, Integer> {
	
	public Image getUserPhoto(final Integer userId) throws SystemException {
		Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
		return super.getByNamedQuery("Image.getUserPhoto", paramValueMap, Image.class);
	}
	
}
