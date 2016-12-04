package org.professionalprofile.core.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private String name;
    private String site;
    private Image logo;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(length = 100, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 100, nullable = true)
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", insertable = true, updatable = true)
    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }
}
