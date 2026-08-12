package com.ferbo.bitacora.model;

import java.time.LocalDate;

import com.ferbo.bitacora.exception.BitacoraException;

public class FiltroBitacora {
    private String documento;
    
    private Integer idUsuario;

    private String usuario;

    private LocalDate inicio;

    private LocalDate fin;

    private String nombrePantalla;

    private String tipoPantalla;

    public FiltroBitacora() {
    }

    public FiltroBitacora(String documento, Integer idUsuario, String usuario, LocalDate inicio, LocalDate fin,
            String nombrePantalla, String tipoPantalla) {
        this.documento = documento;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.inicio = inicio;
        this.fin = fin;
        this.nombrePantalla = nombrePantalla;
        this.tipoPantalla = tipoPantalla;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) throws BitacoraException {
        if ("".equalsIgnoreCase(documento)){
            throw new BitacoraException( "Filtro","No se puede filtrar por un documento vacío");
        }
        this.documento = documento;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public String getNombrePantalla() {
        return nombrePantalla;
    }

    public void setNombrePantalla(String nombrePantalla) {
        this.nombrePantalla = nombrePantalla;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
}
