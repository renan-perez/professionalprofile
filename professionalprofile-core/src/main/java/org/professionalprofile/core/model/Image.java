package org.professionalprofile.core.model;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(schema = "renanpe_professionalprofile", name = "image")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private String fileName;
    private Byte[] content;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Column(length = 50, nullable = false)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Lob
    @Column(nullable = false)
    public Byte[] getContent() {
        return content;
    }

    public void setContent(Byte[] content) {
        this.content = content;
    }
}
