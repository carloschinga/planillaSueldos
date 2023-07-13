/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestor.dto;

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
 * @author 51933
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByCodiTrab", query = "SELECT t FROM Trabajador t WHERE t.codiTrab = :codiTrab"),
    @NamedQuery(name = "Trabajador.findByCodiTipoDocu", query = "SELECT t FROM Trabajador t WHERE t.codiTipoDocu = :codiTipoDocu"),
    @NamedQuery(name = "Trabajador.findByNumeDocu", query = "SELECT t FROM Trabajador t WHERE t.numeDocu = :numeDocu"),
    @NamedQuery(name = "Trabajador.findByAppaTrab", query = "SELECT t FROM Trabajador t WHERE t.appaTrab = :appaTrab"),
    @NamedQuery(name = "Trabajador.findByApmaTrab", query = "SELECT t FROM Trabajador t WHERE t.apmaTrab = :apmaTrab"),
    @NamedQuery(name = "Trabajador.findByNombTrab", query = "SELECT t FROM Trabajador t WHERE t.nombTrab = :nombTrab"),
    @NamedQuery(name = "Trabajador.findBySueldBasi", query = "SELECT t FROM Trabajador t WHERE t.sueldBasi = :sueldBasi"),
    @NamedQuery(name = "Trabajador.findByTeneAsigFami", query = "SELECT t FROM Trabajador t WHERE t.teneAsigFami = :teneAsigFami")})
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codiTrab")
    private Integer codiTrab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codiTipoDocu")
    private int codiTipoDocu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numeDocu")
    private String numeDocu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "appaTrab")
    private String appaTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apmaTrab")
    private String apmaTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombTrab")
    private String nombTrab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldBasi")
    private double sueldBasi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teneAsigFami")
    private Character teneAsigFami;

    public Trabajador() {
    }

    public Trabajador(Integer codiTrab) {
        this.codiTrab = codiTrab;
    }

    public Trabajador(Integer codiTrab, int codiTipoDocu, String numeDocu, String appaTrab, String apmaTrab, String nombTrab, double sueldBasi, Character teneAsigFami) {
        this.codiTrab = codiTrab;
        this.codiTipoDocu = codiTipoDocu;
        this.numeDocu = numeDocu;
        this.appaTrab = appaTrab;
        this.apmaTrab = apmaTrab;
        this.nombTrab = nombTrab;
        this.sueldBasi = sueldBasi;
        this.teneAsigFami = teneAsigFami;
    }

    public Integer getCodiTrab() {
        return codiTrab;
    }

    public void setCodiTrab(Integer codiTrab) {
        this.codiTrab = codiTrab;
    }

    public int getCodiTipoDocu() {
        return codiTipoDocu;
    }

    public void setCodiTipoDocu(int codiTipoDocu) {
        this.codiTipoDocu = codiTipoDocu;
    }

    public String getNumeDocu() {
        return numeDocu;
    }

    public void setNumeDocu(String numeDocu) {
        this.numeDocu = numeDocu;
    }

    public String getAppaTrab() {
        return appaTrab;
    }

    public void setAppaTrab(String appaTrab) {
        this.appaTrab = appaTrab;
    }

    public String getApmaTrab() {
        return apmaTrab;
    }

    public void setApmaTrab(String apmaTrab) {
        this.apmaTrab = apmaTrab;
    }

    public String getNombTrab() {
        return nombTrab;
    }

    public void setNombTrab(String nombTrab) {
        this.nombTrab = nombTrab;
    }

    public double getSueldBasi() {
        return sueldBasi;
    }

    public void setSueldBasi(double sueldBasi) {
        this.sueldBasi = sueldBasi;
    }

    public Character getTeneAsigFami() {
        return teneAsigFami;
    }

    public void setTeneAsigFami(Character teneAsigFami) {
        this.teneAsigFami = teneAsigFami;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiTrab != null ? codiTrab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.codiTrab == null && other.codiTrab != null) || (this.codiTrab != null && !this.codiTrab.equals(other.codiTrab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Trabajador[ codiTrab=" + codiTrab + " ]";
    }
    
}
