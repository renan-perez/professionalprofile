package org.professionalprofile.core.enums;

import java.util.Arrays;
import java.util.List;

public enum ContactType {
    EMAIL(1),
    TELEPHONE(2),
    LINKEDIN(3),
    GITHUB(4),
    TWITTER(5),
    WEBSITE(6);

    private Integer id;

    public static List<ContactType> ENUMS = Arrays.asList(values());

    private ContactType(Integer id) {
        this.id = id;
    }
}
