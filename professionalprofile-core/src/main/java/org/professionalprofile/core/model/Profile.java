package org.professionalprofile.core.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

@NamedQueries({
    @NamedQuery(
        name = "Profile.getMainProfile",
        query = "SELECT p " +
                "FROM   Profile p " +
                "WHERE  p.mainProfile   = TRUE " +
                "AND    p.id.user.id    = :userId"
    ),
    @NamedQuery(
            name = "Profile.getByLanguage",
            query = "SELECT p FROM Profile p WHERE p.id.language = :language"
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
    private Set<Skill> skills;

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
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "profile_has_skills",
        joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, updatable = false),
            @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false, updatable = false)},
        inverseJoinColumns = {
            @JoinColumn(name = "skill_name", nullable = false, updatable = false)}
    )
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
