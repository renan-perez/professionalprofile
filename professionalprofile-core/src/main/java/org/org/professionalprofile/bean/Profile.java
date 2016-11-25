package org.org.professionalprofile.bean;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by renan on 24/11/2016.
 */
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private String professionalTitle;
    private String occupationArea;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(String occupationArea) {
        this.occupationArea = occupationArea;
    }
}
