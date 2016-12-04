package org.professionalprofile.core.model;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
    @NamedQuery(name = "Skill.list", query = "select s from Skill s" )
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "skill")
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
