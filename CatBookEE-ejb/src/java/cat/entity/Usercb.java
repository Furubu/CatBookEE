/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kuroneko
 */
@Entity
@Table(name = "USERCB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercb.findAll", query = "SELECT u FROM Usercb u"),
    @NamedQuery(name = "Usercb.findById", query = "SELECT u FROM Usercb u WHERE u.id = :id"),
    @NamedQuery(name = "Usercb.findByEmail", query = "SELECT u FROM Usercb u WHERE u.email = :email"),
    @NamedQuery(name = "Usercb.findByPassword", query = "SELECT u FROM Usercb u WHERE u.password = :password"),
    @NamedQuery(name = "Usercb.findByName", query = "SELECT u FROM Usercb u WHERE u.name = :name"),
    @NamedQuery(name = "Usercb.findBySurname", query = "SELECT u FROM Usercb u WHERE u.surname = :surname"),
    @NamedQuery(name = "Usercb.findByPicture", query = "SELECT u FROM Usercb u WHERE u.picture = :picture")})
public class Usercb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 30)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 100)
    @Column(name = "PICTURE")
    private String picture;
    @JoinTable(name = "FRIENDS", joinColumns = {
        @JoinColumn(name = "USER_FRIENDS", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FRIENDS_USER", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usercb> usercbCollection;
    @ManyToMany(mappedBy = "usercbCollection")
    private Collection<Usercb> usercbCollection1;
    @JoinTable(name = "USER_GROUP", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Groupcb> groupcbCollection;
    @JoinTable(name = "BLOCKED", joinColumns = {
        @JoinColumn(name = "BLOCKING", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "BLOCKEDBY", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Usercb> usercbCollection2;
    @ManyToMany(mappedBy = "usercbCollection2")
    private Collection<Usercb> usercbCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usercbId")
    private Collection<Postcb> postcbCollection;

    public Usercb() {
    }

    public Usercb(Integer id) {
        this.id = id;
    }

    public Usercb(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @XmlTransient
    public Collection<Usercb> getUsercbCollection() {
        return usercbCollection;
    }

    public void setUsercbCollection(Collection<Usercb> usercbCollection) {
        this.usercbCollection = usercbCollection;
    }

    @XmlTransient
    public Collection<Usercb> getUsercbCollection1() {
        return usercbCollection1;
    }

    public void setUsercbCollection1(Collection<Usercb> usercbCollection1) {
        this.usercbCollection1 = usercbCollection1;
    }

    @XmlTransient
    public Collection<Groupcb> getGroupcbCollection() {
        return groupcbCollection;
    }

    public void setGroupcbCollection(Collection<Groupcb> groupcbCollection) {
        this.groupcbCollection = groupcbCollection;
    }

    @XmlTransient
    public Collection<Usercb> getUsercbCollection2() {
        return usercbCollection2;
    }

    public void setUsercbCollection2(Collection<Usercb> usercbCollection2) {
        this.usercbCollection2 = usercbCollection2;
    }

    @XmlTransient
    public Collection<Usercb> getUsercbCollection3() {
        return usercbCollection3;
    }

    public void setUsercbCollection3(Collection<Usercb> usercbCollection3) {
        this.usercbCollection3 = usercbCollection3;
    }

    @XmlTransient
    public Collection<Postcb> getPostcbCollection() {
        return postcbCollection;
    }

    public void setPostcbCollection(Collection<Postcb> postcbCollection) {
        this.postcbCollection = postcbCollection;
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
        if (!(object instanceof Usercb)) {
            return false;
        }
        Usercb other = (Usercb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cat.entity.Usercb[ id=" + id + " ]";
    }
    
}
