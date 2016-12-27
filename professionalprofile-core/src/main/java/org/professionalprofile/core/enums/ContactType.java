package org.professionalprofile.core.enums;

import java.util.Arrays;
import java.util.List;

public enum ContactType {
	
    EMAIL,
    TELEPHONE,
    LINKEDIN,
    GITHUB,
    TWITTER,
    WEBSITE;

    public static List<ContactType> ENUMS = Arrays.asList(values());

}
