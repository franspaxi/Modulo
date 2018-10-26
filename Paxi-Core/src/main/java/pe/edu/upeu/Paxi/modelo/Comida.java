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
@Table(name = "comida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comida.findAll", query = "SELECT c FROM Comida c")
    , @NamedQuery(name = "Comida.findByIdcomida", query = "SELECT c FROM Comida c WHERE c.idcomida = :idcomida")
    , @NamedQuery(name = "Comida.findByDesayuno", query = "SELECT c FROM Comida c WHERE c.desayuno = :desayuno")
    , @NamedQuery(name = "Comida.findByAlmuerzo", query = "SELECT c FROM Comida c WHERE c.almuerzo = :almuerzo")
    , @NamedQuery(name = "Comida.findByCena", query = "SELECT c FROM Comida c WHERE c.cena = :cena")
    , @NamedQuery(name = "Comida.findByCosto", query = "SELECT c FROM Comida c WHERE c.costo = :costo")
    , @NamedQuery(name = "Comida.findByObservaciones", query = "SELECT c FROM Comida c WHERE c.observaciones = :observaciones")})
public class Comida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcomida")
    private Integer idcomida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "desayuno")
    private String desayuno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "almuerzo")
    private String almuerzo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cena")
    private String cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "costo")
    private String costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcomida")
    private Collection<Total> totalCollection;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;

    public Comida() {
    }

    public Comida(Integer idcomida) {
        this.idcomida = idcomida;
    }

    public Comida(Integer idcomida, String desayuno, String almuerzo, String cena, String costo, String observaciones) {
        this.idcomida = idcomida;
        this.desayuno = desayuno;
        this.almuerzo = almuerzo;
        this.cena = cena;
        this.costo = costo;
        this.observaciones = observaciones;
    }

    public Integer getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(Integer idcomida) {
        this.idcomida = idcomida;
    }

    public String getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(String desayuno) {
        this.desayuno = desayuno;
    }

    public String getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(String almuerzo) {
        this.almuerzo = almuerzo;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Total> getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Collection<Total> totalCollection) {
        this.totalCollection = totalCollection;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomida != null ? idcomida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comida)) {
            return false;
        }
        Comida other = (Comida) object;
        if ((this.idcomida == null && other.idcomida != null) || (this.idcomida != null && !this.idcomida.equals(other.idcomida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idcomida;
    }
    
}
