/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Userpics.findAll", query = "SELECT u FROM Userpics u")
    , @NamedQuery(name = "Userpics.findById", query = "SELECT u FROM Userpics u WHERE u.id = :id")
    , @NamedQuery(name = "Userpics.findByUserID", query = "SELECT u FROM Userpics u WHERE u.userID = :userID")
    , @NamedQuery(name = "Userpics.findByUserpic", query = "SELECT u FROM Userpics u WHERE u.userpic = :userpic")
    , @NamedQuery(name = "Userpics.findByAvatar", query = "SELECT u FROM Userpics u WHERE u.avatar = :avatar")})
public class Userpics implements Serializable {

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
    @Size(max = 255)
    @Column(length = 255)
    private String userpic;
    @Size(max = 255)
    @Column(length = 255)
    private String avatar;

    public Userpics() {
    }

    public Userpics(Integer id) {
        this.id = id;
    }

    public Userpics(Integer id, int userID) {
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

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
        if (!(object instanceof Userpics)) {
            return false;
        }
        Userpics other = (Userpics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Userpics[ id=" + id + " ]";
    }
    
}
