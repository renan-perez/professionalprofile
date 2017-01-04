package org.professionalprofile.core.model;

import static javax.persistence.EnumType.STRING;
import static  javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.professionalprofile.core.enums.ContactType;

@NamedQueries({
        @NamedQuery(
                name ="Contact.getMainContact",
                query = "SELECT c " +
                        "FROM   Contact c " +
                        "WHERE  c.mainContact   = TRUE " +
                        "AND    c.user.id       = :userId")
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private ContactType type;
    private String contact;
    private Boolean mainContact;
    private User user;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Enumerated(STRING)
    @Column(length = 10)
    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    @NotEmpty
    @Column(length = 100)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(nullable = false)
    public Boolean isMainContact() {
        return mainContact;
    }

    public void setMainContact(Boolean mainContact) {
        this.mainContact = mainContact;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}