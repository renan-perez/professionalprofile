package org.professionalprofile.core.model;

import javax.persistence.*;

import org.professionalprofile.core.enums.ExperienceLevel;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

@NamedQueries({
    @NamedQuery(
    		name = "Skill.listUserSkills", 
    		query = "SELECT 	s " +
    				"FROM		Skill	s " +
    				"INNER JOIN	User	u " +
    				"ON		u.id	= :userId ")
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "skill")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private ExperienceLevel experienceLevel;
   
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Enumerated(STRING)
    @Column(length = 10)
	public ExperienceLevel getExperienceLevel() {
		return experienceLevel;
	}

	public void setExperienceLevel(ExperienceLevel experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	
}
