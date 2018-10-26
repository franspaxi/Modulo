/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOSHIBA
 */
@Entity
@Table(name = "total")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Total.findAll", query = "SELECT t FROM Total t")
    , @NamedQuery(name = "Total.findByIdtotal", query = "SELECT t FROM Total t WHERE t.idtotal = :idtotal")
    , @NamedQuery(name = "Total.findByPreciototal", query = "SELECT t FROM Total t WHERE t.preciototal = :preciototal")})
public class Total implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtotal")
    private Integer idtotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "preciototal")
    private String preciototal;
    @JoinColumn(name = "idcomida", referencedColumnName = "idcomida")
    @ManyToOne(optional = false)
    private Comida idcomida;
    @JoinColumn(name = "idfecha", referencedColumnName = "idfecha")
    @ManyToOne(optional = false)
    private Fecha idfecha;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;

    public Total() {
    }

    public Total(Integer idtotal) {
        this.idtotal = idtotal;
    }

    public Total(Integer idtotal, String preciototal) {
        this.idtotal = idtotal;
        this.preciototal = preciototal;
    }

    public Integer getIdtotal() {
        return idtotal;
    }

    public void setIdtotal(Integer idtotal) {
        this.idtotal = idtotal;
    }

    public String getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(String preciototal) {
        this.preciototal = preciototal;
    }

    public Comida getIdcomida() {
        return idcomida;
    }

    public void setIdcomida(Comida idcomida) {
        this.idcomida = idcomida;
    }

    public Fecha getIdfecha() {
        return idfecha;
    }

    public void setIdfecha(Fecha idfecha) {
        this.idfecha = idfecha;
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
        hash += (idtotal != null ? idtotal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Total)) {
            return false;
        }
        Total other = (Total) object;
        if ((this.idtotal == null && other.idtotal != null) || (this.idtotal != null && !this.idtotal.equals(other.idtotal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idtotal;
    }
    
}
