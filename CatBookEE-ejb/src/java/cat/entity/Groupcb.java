    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "GROUPCB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupcb.findAll", query = "SELECT g FROM Groupcb g"),
    @NamedQuery(name = "Groupcb.findById", query = "SELECT g FROM Groupcb g WHERE g.id = :id"),
    @NamedQuery(name = "Groupcb.findByNombre", query = "SELECT g FROM Groupcb g WHERE g.nombre = :nombre")})
public class Groupcb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "NOMBRE")
    private String nombre;
    @ManyToMany(mappedBy = "groupcbCollection")
    private Collection<Usercb> usercbCollection;
    @OneToMany(mappedBy = "groupcbId")
    private Collection<Postcb> postcbCollection;

    public Groupcb() {
    }

    public Groupcb(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Usercb> getUsercbCollection() {
        return usercbCollection;
    }

    public void setUsercbCollection(Collection<Usercb> usercbCollection) {
        this.usercbCollection = usercbCollection;
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
        if (!(object instanceof Groupcb)) {
            return false;
        }
        Groupcb other = (Groupcb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cat.entity.Groupcb[ id=" + id + " ]";
    }
    
}
