package org.professionalprofile.core.model;

import org.professionalprofile.core.enums.Language;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

@Embeddable
public class ProfileId implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;
    private Language language;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Enumerated(STRING)
    @Column(name = "language", length = 2)
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
