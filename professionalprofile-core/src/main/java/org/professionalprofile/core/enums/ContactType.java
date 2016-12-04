package org.professionalprofile.core.enums;

public enum ContactType {
    EMAIL(1),
    TELEPHONE(2);

    private Integer id;

    private ContactType(Integer id) {
        this.id = id;
    }
}
