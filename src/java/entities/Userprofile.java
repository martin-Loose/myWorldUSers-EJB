/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlo0212
 */
@Entity
@Table(catalog = "myworld_users", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userprofile.findAll", query = "SELECT u FROM Userprofile u")
    , @NamedQuery(name = "Userprofile.findById", query = "SELECT u FROM Userprofile u WHERE u.id = :id")
    , @NamedQuery(name = "Userprofile.findByRealfirstname", query = "SELECT u FROM Userprofile u WHERE u.realfirstname = :realfirstname")
    , @NamedQuery(name = "Userprofile.findByReal2ndname", query = "SELECT u FROM Userprofile u WHERE u.real2ndname = :real2ndname")
    , @NamedQuery(name = "Userprofile.findByReallastname", query = "SELECT u FROM Userprofile u WHERE u.reallastname = :reallastname")
    , @NamedQuery(name = "Userprofile.findByDob", query = "SELECT u FROM Userprofile u WHERE u.dob = :dob")
    , @NamedQuery(name = "Userprofile.findByBornin", query = "SELECT u FROM Userprofile u WHERE u.bornin = :bornin")
    , @NamedQuery(name = "Userprofile.findByLivingin", query = "SELECT u FROM Userprofile u WHERE u.livingin = :livingin")
    , @NamedQuery(name = "Userprofile.findByUserID", query = "SELECT u FROM Userprofile u WHERE u.userID = :userID")})
public class Userprofile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(nullable = false, length = 60)
    private String realfirstname;
    @Size(max = 60)
    @Column(length = 60)
    private String real2ndname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(nullable = false, length = 60)
    private String reallastname;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 60)
    @Column(length = 60)
    private String bornin;
    @Size(max = 180)
    @Column(length = 180)
    private String livingin;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int userID;

    public Userprofile() {
    }

    public Userprofile(Integer id) {
        this.id = id;
    }

    public Userprofile(Integer id, String realfirstname, String reallastname, int userID) {
        this.id = id;
        this.realfirstname = realfirstname;
        this.reallastname = reallastname;
        this.userID = userID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealfirstname() {
        return realfirstname;
    }

    public void setRealfirstname(String realfirstname) {
        this.realfirstname = realfirstname;
    }

    public String getReal2ndname() {
        return real2ndname;
    }

    public void setReal2ndname(String real2ndname) {
        this.real2ndname = real2ndname;
    }

    public String getReallastname() {
        return reallastname;
    }

    public void setReallastname(String reallastname) {
        this.reallastname = reallastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBornin() {
        return bornin;
    }

    public void setBornin(String bornin) {
        this.bornin = bornin;
    }

    public String getLivingin() {
        return livingin;
    }

    public void setLivingin(String livingin) {
        this.livingin = livingin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userprofile)) {
            return false;
        }
        Userprofile other = (Userprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userprofile[ id=" + id + " ]";
    }
    
}
