package com.ferbo.bitacora.dto;

import java.util.Date;

public class BitacoraDTO {

    private String documento;
    private Integer idUsuario;
    private String usuario;
    private String nombrePantalla;
    private String tipoPantalla;
    private Date momento;

    public BitacoraDTO() {
    }

    public BitacoraDTO(String documento,
            Integer idUsuario, String usuario, 
            String nombrePantalla,
            String tipoPantalla,
            Date momento) {

        this.documento = documento;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.nombrePantalla = nombrePantalla;
        this.tipoPantalla = tipoPantalla;
        this.momento = momento; 

    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

}
