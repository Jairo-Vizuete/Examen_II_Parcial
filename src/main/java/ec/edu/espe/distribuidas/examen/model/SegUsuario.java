/*
 * Copyright (c) 2021 Javp_.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Javp_ - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.examen.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Javp_
 */
@Data
@Entity
@Table(name = "seg_usuario")
public class SegUsuario implements Serializable {

    @Id
    @Column(name = "cod_usuario", nullable = false, length = 30)
    private String codUsuario;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "identificacion", nullable = false, length = 30)
    private String identificacion;

    @Column(name = "email", length = 250)
    private String email;

    @Column(name = "estado", nullable = false, length = 3)
    private String estado;

    @Column(name = "nro_intentos_fallidos")
    private Integer nroIntentosFallidos;

    @Column(name = "fecha_ultima_sesion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaSesion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private List<SegUsuarioPerfil> segUsuarioPerfilList;

    public SegUsuario() {
    }

    public SegUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public SegUsuario(String codUsuario, String nombre, String identificacion, String estado) {
        this.codUsuario = codUsuario;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.estado = estado;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNroIntentosFallidos() {
        return nroIntentosFallidos;
    }

    public void setNroIntentosFallidos(Integer nroIntentosFallidos) {
        this.nroIntentosFallidos = nroIntentosFallidos;
    }

    public Date getFechaUltimaSesion() {
        return fechaUltimaSesion;
    }

    public void setFechaUltimaSesion(Date fechaUltimaSesion) {
        this.fechaUltimaSesion = fechaUltimaSesion;
    }

    public List<SegUsuarioPerfil> getSegUsuarioPerfilList() {
        return segUsuarioPerfilList;
    }

    public void setSegUsuarioPerfilList(List<SegUsuarioPerfil> segUsuarioPerfilList) {
        this.segUsuarioPerfilList = segUsuarioPerfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.examen.model.SegUsuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
