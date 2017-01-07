package org.professionalprofile.core.dao;

import org.professionalprofile.core.enums.ContactType;
import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Contact;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ContactDAO extends GenericDAO<Contact, BigInteger> {

    public Contact getMainContact(Integer userId) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
        return super.getByNamedQuery("Contact.getMainContact", paramValueMap, Contact.class);
    }
    
    public List<Contact> listUserContactByType(final Integer userId, final List<ContactType> typeList) throws SystemException {
    	Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
        paramValueMap.put("typeList", typeList);
        return (List<Contact>) super.listByNamedQuery("Contact.getUserSocialNetworks", paramValueMap, Contact.class);
    }

}
