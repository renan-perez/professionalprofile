package org.professionalprofile.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProfileId id;
    private String professionalHeadline;
    private String industry;
    private Boolean mainProfile;
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

    @Column(nullable = false)
    public Boolean isMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(Boolean mainProfile) {
        this.mainProfile = mainProfile;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "profile_has_skills", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false),
            @JoinColumn(name = "language_id", nullable = false, updatable = false)
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "name", nullable = false, updatable = false)
            }
    )
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
