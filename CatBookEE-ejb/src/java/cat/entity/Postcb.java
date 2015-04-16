/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author kuroneko
 */
@Entity
@Table(name = "POSTCB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postcb.findAll", query = "SELECT p FROM Postcb p"),
    @NamedQuery(name = "Postcb.findById", query = "SELECT p FROM Postcb p WHERE p.id = :id"),
    @NamedQuery(name = "Postcb.findByFecha", query = "SELECT p FROM Postcb p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Postcb.findByTexto", query = "SELECT p FROM Postcb p WHERE p.texto = :texto"),
    @NamedQuery(name = "Postcb.findByPicture", query = "SELECT p FROM Postcb p WHERE p.picture = :picture")})
public class Postcb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 3000)
    @Column(name = "TEXTO")
    private String texto;
    @Size(max = 100)
    @Column(name = "PICTURE")
    private String picture;
    @JoinColumn(name = "GROUPCB_ID", referencedColumnName = "ID")
    @ManyToOne
    private Groupcb groupcbId;
    @JoinColumn(name = "USERCB_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usercb usercbId;

    public Postcb() {
    }

    public Postcb(Integer id) {
        this.id = id;
    }

    public Postcb(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Groupcb getGroupcbId() {
        return groupcbId;
    }

    public void setGroupcbId(Groupcb groupcbId) {
        this.groupcbId = groupcbId;
    }

    public Usercb getUsercbId() {
        return usercbId;
    }

    public void setUsercbId(Usercb usercbId) {
        this.usercbId = usercbId;
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
        if (!(object instanceof Postcb)) {
            return false;
        }
        Postcb other = (Postcb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cat.entity.Postcb[ id=" + id + " ]";
    }
    
}
