package org.professionalprofile.core.dao;

import org.professionalprofile.core.exception.SystemException;
import org.professionalprofile.core.model.Contact;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ContactDAO extends GenericDAO<Contact, BigInteger> {

    public Contact getMainContact(BigInteger userId) throws SystemException {
        Map<String, Object> paramValueMap = new HashMap<>();
        paramValueMap.put("userId", userId);
        return super.getByNamedQuery("Contact.getMainContact", paramValueMap, Contact.class);
    }

}
