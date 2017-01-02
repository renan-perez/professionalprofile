package org.professionalprofile.core.model;

import static javax.persistence.GenerationType.IDENTITY;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "experience")
public class Experience implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private String title;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private String Description;
    private String site;
    private Company company;
    private Profile profile;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    @Lob
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
            @JoinColumn(name = "profile_language_id", referencedColumnName = "language_id", insertable = false, updatable = false),
    })
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
