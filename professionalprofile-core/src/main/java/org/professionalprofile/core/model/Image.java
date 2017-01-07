package org.professionalprofile.core.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
			name="Image.getUserPhoto",
			query="SELECT		i " + 
				  "FROM			Image 	i " + 
				  "INNER JOIN	User 	u " +
				  "ON 			u.id = 		:userId")
})

@Entity
@Table(schema = "renanpe_professionalprofile", name = "image")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String fileName;
    private byte[] content;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
