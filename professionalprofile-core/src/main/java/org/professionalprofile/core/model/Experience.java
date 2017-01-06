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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({
	@NamedQuery(
			name="Experience.getNewestExperience",
			query="SELECT	e " +
				  "FROM		Experience e " +
				  "ORDER BY e.initialDate DESC"),
	
	@NamedQuery(
			name="Experience.getOlderExperience",
			query="SELECT	e " +
				  "FROM		Experience e " +
				  "WHERE	e.initialDate < :inicialDate " +
				  "ORDER BY e.initialDate DESC "),
	
	@NamedQuery(
			name="Experience.getNewerExperience",
			query="SELECT	e " +
				  "FROM		Experience e " +
				  "WHERE	e.initialDate > :inicialDate " +
				  "ORDER BY e.initialDate DESC"),
	
	@NamedQuery(
			name="Experience.getOldestExperience",
			query="SELECT	e " +
				  "FROM		Experience e " +
				  "ORDER BY e.initialDate"),
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "experience")
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private String Description;
    private String site;
    private Company company;
    private Profile profile;
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

    @Column(length = 50, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
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

    @Column(nullable = true)
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Column(length = 100, nullable = true)
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
}
