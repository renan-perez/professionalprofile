package org.professionalprofile.core.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.professionalprofile.core.enums.ContactType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

import static javax.persistence.EnumType.ORDINAL;
import static  javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private ContactType type;
    private String contact;
    private User user;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @NotNull
    @Enumerated(ORDINAL)
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}