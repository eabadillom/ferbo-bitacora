package com.ferbo.bitacora.model;

import com.ferbo.bitacora.exception.BitacoraException;

public class ContextoBitacora {

    private final String idSesion;

    private final Integer idUsuario;

    private final String usuario;

    private final String nombrePantalla;

    private final String tipoPantalla;

    private final String codigo = "Contexto";

    private ContextoBitacora(String idSesion, Integer idUsuario, String usuario, String nombrePantalla,
            String tipoPantalla) throws BitacoraException {

        validacionDeDatos(idSesion, idUsuario, usuario, nombrePantalla, tipoPantalla);

        this.idSesion = idSesion;
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.nombrePantalla = nombrePantalla;
        this.tipoPantalla = tipoPantalla;
    }

    private void validacionDeDatos(String idSesion, Integer idUsuario, String usuario, String nombrePantalla,
            String tipoPantalla) throws BitacoraException {
        if (idSesion == null || "".equalsIgnoreCase(idSesion)) {
            throw new BitacoraException(codigo, "La bitacora necesita una sesión y no puede ser vacía");
        }

        if (idUsuario == null || idUsuario.compareTo(0) <= 0) {
            throw new BitacoraException(codigo, "El identificador del usuario debe ser mayor a cero y no vacío");
        }

        if (usuario == null || "".equalsIgnoreCase(usuario)) {
            throw new BitacoraException(codigo, "El usuario no puede ser vacío");
        }

        if (nombrePantalla == null || "".equalsIgnoreCase(nombrePantalla)) {
            throw new BitacoraException(codigo, "El nombre de la pantalla no puede ser vacío");
        }

        if (tipoPantalla == null || "".equalsIgnoreCase(tipoPantalla)) {
            throw new BitacoraException(codigo, "El tipo de pantalla no puede ser vacío");
        }

    }

    public static ContextoBitacora of(
            String idSesion,
            Integer idUsuario,
            String usuario,
            String nombrePantalla,
            String tipoPantalla) throws BitacoraException {

        return new ContextoBitacora(
                idSesion,
                idUsuario,
                usuario,
                nombrePantalla,
                tipoPantalla);
    }

    public String getIdSesion() {
        return idSesion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombrePantalla() {
        return nombrePantalla;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    @Override
    public String toString() {
        return "ContextBitacora{" +
                "idSesion='" + idSesion + '\'' +
                ", idUsuario= " + idUsuario +
                ", usuario=" + usuario +
                ", nombrePantalla=" + nombrePantalla +
                ", tipoPantalla=" + tipoPantalla +
                '}';
    }

}
