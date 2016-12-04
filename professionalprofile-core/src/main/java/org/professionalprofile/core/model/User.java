package org.professionalprofile.core.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private String firstName;
    private String surname;
    private Short age;
    private Location location;
    private Image photo;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(length = 50, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(length = 50, nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotNull
    @Min(value = 0)
    @Column(nullable = false)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
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
    @JoinColumn(name = "image_id", referencedColumnName = "id", insertable = true, updatable = true)
    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
