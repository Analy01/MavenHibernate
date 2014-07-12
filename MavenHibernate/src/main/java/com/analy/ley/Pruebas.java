/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.analy.ley;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author T107
 */
@Entity
@Table(name = "pruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pruebas.findAll", query = "SELECT p FROM Pruebas p"),
    @NamedQuery(name = "Pruebas.findById", query = "SELECT p FROM Pruebas p WHERE p.id = :id"),
    @NamedQuery(name = "Pruebas.findByNombre", query = "SELECT p FROM Pruebas p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pruebas.findBySueldo", query = "SELECT p FROM Pruebas p WHERE p.sueldo = :sueldo")})
public class Pruebas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "sueldo")
    private int sueldo;

    public Pruebas() {
    }

    public Pruebas(Integer id, String nombre, int sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 11 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 11 * hash + this.sueldo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pruebas other = (Pruebas) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if (this.sueldo != other.sueldo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pruebas{" + "id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }

    
    
}
