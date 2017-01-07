package org.professionalprofile.core.model;

import static javax.persistence.GenerationType.IDENTITY;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({
	@NamedQuery(
			name="Education.listUserEducation",
			query="SELECT	e " +
				  "FROM		Education e " +
				  "WHERE	e.profile.id.user.id	= :userId " +
				  "AND		e.profile.id.language	= :language"
	)
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "education")
public class Education implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String school;
	private String course;
	private String fildOfStudy;
	private LocalDate initialDate;
	private LocalDate finalDate;
	private Location location;
	private Profile profile;
	private Image logo;
	private Integer years;
	private Integer months;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length = 100, nullable = false)
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Column(length = 100, nullable = false)
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Column(length = 50, nullable = false)
	public String getFildOfStudy() {
		return fildOfStudy;
	}

	public void setFildOfStudy(String fildOfStudy) {
		this.fildOfStudy = fildOfStudy;
	}
	
	@Column(nullable = true)
	@DateTimeFormat(iso = DATE)
	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}
	
	@Column(nullable = true)
	@DateTimeFormat(iso = DATE)
	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}
	
	@NotNull
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", insertable = true, updatable = true)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@ManyToOne
    @JoinColumns({
            @JoinColumn(name = "profile_user_id", referencedColumnName = "user_id", insertable = false, updatable = false),
            @JoinColumn(name = "profile_language", referencedColumnName = "language", insertable = false, updatable = false),
    })
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    @Transient
	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}
	
	@Transient
	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}
	
	@ManyToOne
    @JoinColumn(columnDefinition = "image_id", referencedColumnName = "id", updatable = true, insertable = true)
	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
    	
}
