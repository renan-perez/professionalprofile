package org.professionalprofile.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@NamedQueries({
    @NamedQuery(
        name = "Profile.getMainInformation",
        query = "SELECT p " +
                "FROM   Profile p " +
                "WHERE  (:mainProfile	IS NULL	OR	p.mainProfile   = :mainProfile) " +
                "AND	(:language 		IS NULL OR	p.id.language	= :language) " +
                "AND    p.id.user.id    = :userId"
    ),
    @NamedQuery(
            name = "Profile.getByLanguage",
            query = "SELECT	p "+
            		"FROM 	Profile	p WHERE p.id.language = :language"
    ),
    @NamedQuery(
        name = "Profile.listAvailableProfileLanguages",
        query = "SELECT p.id.language FROM Profile p"
    ),
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProfileId id;
    private String professionalHeadline;
    private String industry;
    private String summary;
    private Boolean mainProfile;
    private Contact mainContact;

    @EmbeddedId
    public ProfileId getId() {
        return id;
    }

    public void setId(ProfileId id) {
        this.id = id;
    }

    @Column(length = 50)
    public String getProfessionalHeadline() {
        return professionalHeadline;
    }

    public void setProfessionalHeadline(String professionalHeadline) {
        this.professionalHeadline = professionalHeadline;
    }

    @Column(length = 50)
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    @Type(type="boolean")
    @Column(nullable = false)
    public Boolean isMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(Boolean mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Transient
    public Contact getMainContact() {
        return mainContact;
    }

    public void setMainContact(Contact mainContact) {
        this.mainContact = mainContact;
    }
    
}
