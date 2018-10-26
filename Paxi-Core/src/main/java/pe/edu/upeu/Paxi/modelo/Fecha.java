/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author TOSHIBA
 */
@Entity
@Table(name = "fecha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fecha.findAll", query = "SELECT f FROM Fecha f")
    , @NamedQuery(name = "Fecha.findByIdfecha", query = "SELECT f FROM Fecha f WHERE f.idfecha = :idfecha")
    , @NamedQuery(name = "Fecha.findByFechainicio", query = "SELECT f FROM Fecha f WHERE f.fechainicio = :fechainicio")
    , @NamedQuery(name = "Fecha.findByFechafin", query = "SELECT f FROM Fecha f WHERE f.fechafin = :fechafin")
    , @NamedQuery(name = "Fecha.findByCosto", query = "SELECT f FROM Fecha f WHERE f.costo = :costo")})
public class Fecha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfecha")
    private Integer idfecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fechainicio")
    private String fechainicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fechafin")
    private String fechafin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "costo")
    private String costo;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfecha")
    private Collection<Total> totalCollection;

    public Fecha() {
    }

    public Fecha(Integer idfecha) {
        this.idfecha = idfecha;
    }

    public Fecha(Integer idfecha, String fechainicio, String fechafin, String costo) {
        this.idfecha = idfecha;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.costo = costo;
    }

    public Integer getIdfecha() {
        return idfecha;
    }

    public void setIdfecha(Integer idfecha) {
        this.idfecha = idfecha;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @XmlTransient
    public Collection<Total> getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Collection<Total> totalCollection) {
        this.totalCollection = totalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfecha != null ? idfecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fecha)) {
            return false;
        }
        Fecha other = (Fecha) object;
        if ((this.idfecha == null && other.idfecha != null) || (this.idfecha != null && !this.idfecha.equals(other.idfecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idfecha;
    }
    
}
