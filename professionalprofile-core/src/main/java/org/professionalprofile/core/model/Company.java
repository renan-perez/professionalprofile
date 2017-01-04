package org.professionalprofile.core.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String website;
    private Image logo;
    private Location location;
    

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", insertable = true, updatable = true)
    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }
    
    
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", insertable = true, updatable = true)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
