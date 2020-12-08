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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlo0212
 */
@Entity
@Table(catalog = "myworld_users", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Whoisonline.findAll", query = "SELECT w FROM Whoisonline w")
    , @NamedQuery(name = "Whoisonline.findById", query = "SELECT w FROM Whoisonline w WHERE w.id = :id")
    , @NamedQuery(name = "Whoisonline.findByUserID", query = "SELECT w FROM Whoisonline w WHERE w.userID = :userID")
    , @NamedQuery(name = "Whoisonline.findByWhenLastLogin", query = "SELECT w FROM Whoisonline w WHERE w.whenLastLogin = :whenLastLogin")
    , @NamedQuery(name = "Whoisonline.findByWhenLastLogOut", query = "SELECT w FROM Whoisonline w WHERE w.whenLastLogOut = :whenLastLogOut")
    , @NamedQuery(name = "Whoisonline.findByIsOnline", query = "SELECT w FROM Whoisonline w WHERE w.isOnline = :isOnline")})
public class Whoisonline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int userID;
    @Temporal(TemporalType.TIMESTAMP)
    private Date whenLastLogin;
    @Temporal(TemporalType.TIMESTAMP)
    private Date whenLastLogOut;
    private Boolean isOnline;

    public Whoisonline() {
    }

    public Whoisonline(Integer id) {
        this.id = id;
    }

    public Whoisonline(Integer id, int userID) {
        this.id = id;
        this.userID = userID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getWhenLastLogin() {
        return whenLastLogin;
    }

    public void setWhenLastLogin(Date whenLastLogin) {
        this.whenLastLogin = whenLastLogin;
    }

    public Date getWhenLastLogOut() {
        return whenLastLogOut;
    }

    public void setWhenLastLogOut(Date whenLastLogOut) {
        this.whenLastLogOut = whenLastLogOut;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
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
        if (!(object instanceof Whoisonline)) {
            return false;
        }
        Whoisonline other = (Whoisonline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Whoisonline[ id=" + id + " ]";
    }
    
}
