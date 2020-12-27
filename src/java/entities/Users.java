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
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByStartString", query = "SELECT u FROM Users u WHERE  u.username LIKE CONCAT('%', :searchString,'%')")// LIKE CONCAT('%',:searchKeyword,'%')"
        , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByActivatelink", query = "SELECT u FROM Users u WHERE u.activatelink = :activatelink")
    , @NamedQuery(name = "Users.findByBolActivate", query = "SELECT u FROM Users u WHERE u.bolActivate = :bolActivate")
    , @NamedQuery(name = "Users.findByTemppasswort", query = "SELECT u FROM Users u WHERE u.temppasswort = :temppasswort")
    , @NamedQuery(name = "Users.findByLinkgueltigbis", query = "SELECT u FROM Users u WHERE u.linkgueltigbis = :linkgueltigbis")
    , @NamedQuery(name = "Users.findByAvatar", query = "SELECT u FROM Users u WHERE u.avatar = :avatar")
    , @NamedQuery(name = "Users.findByUserPic", query = "SELECT u FROM Users u WHERE u.userPic = :userPic")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Ungültige E-Mail")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String email;
    @Size(max = 255)
    @Column(length = 255)
    private String activatelink;
    private Boolean bolActivate;
    @Size(max = 255)
    @Column(length = 255)
    private String temppasswort;
    @Temporal(TemporalType.TIMESTAMP)
    private Date linkgueltigbis;
    @Size(max = 40)
    @Column(length = 40)
    private String avatar;
    @Size(max = 40)
    @Column(length = 40)
    private String userPic;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivatelink() {
        return activatelink;
    }

    public void setActivatelink(String activatelink) {
        this.activatelink = activatelink;
    }

    public Boolean getBolActivate() {
        return bolActivate;
    }

    public void setBolActivate(Boolean bolActivate) {
        this.bolActivate = bolActivate;
    }

    public String getTemppasswort() {
        return temppasswort;
    }

    public void setTemppasswort(String temppasswort) {
        this.temppasswort = temppasswort;
    }

    public Date getLinkgueltigbis() {
        return linkgueltigbis;
    }

    public void setLinkgueltigbis(Date linkgueltigbis) {
        this.linkgueltigbis = linkgueltigbis;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ id=" + id + " ]";
    }
    
}
