package org.professionalprofile.core.model;

import org.professionalprofile.core.enums.Language;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProfileId implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;
    private Language language;

    @Column(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "language_id")
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
