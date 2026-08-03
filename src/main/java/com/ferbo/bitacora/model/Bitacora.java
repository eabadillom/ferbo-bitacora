package com.ferbo.bitacora.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.ferbo.bitacora.exception.BitacoraException;

@NamedQueries({

        @NamedQuery(name = "Bitacora.findByFiltros", query = "SELECT b FROM Bitacora b " +
                "WHERE (:inicio IS NULL OR b.fecha >= :inicio) " +
                "AND (:fin IS NULL OR b.fecha <= :fin) " +
                "AND (:idUsuario IS NULL OR b.idUsuario = :idUsuario) " +
                "AND (:usuario IS NULL OR b.usuario = :usuario)" +
                "AND (:nombrePantalla IS NULL OR b.nombrePantalla = :nombrePantalla) " +
                "AND (:tipoPantalla IS NULL OR b.tipoPantalla = :tipoPantalla) " +
                "AND (:documento IS NULL OR b.documento = :documento) " +
                "ORDER BY b.id ASC")
})

@NamedNativeQueries ({
    @NamedNativeQuery(name = "Bitacora.findResumenByFiltros", query = "SELECT DISTINCT " + 
                "b.cd_docum, " + 
                "b.cd_usuario, " +
                "b.nb_usuario, " +
                "b.nb_panta, " + 
                "b.tp_panta, " + 
                "b.fh_momento " + 
                "FROM bitacora b " + 
                "WHERE (:inicio IS NULL OR b.fh_momento >= :inicio) " + 
                "AND (:fin IS NULL OR b.fh_momento <= :fin) " + 
                "AND (:idUsuario IS NULL OR b.cd_usuario = :idUsuario) " + 
                "AND (:nombrePantalla IS NULL OR b.nb_panta = :nombrePantalla) " + 
                "AND (:tipoPantalla IS NULL OR b.tp_panta = :tipoPantalla);")
})
@Entity
@Table(name = "bitacora")
public class Bitacora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_bitac")
    private Long id;

    @Column(name = "cd_sesion", nullable = false, length = 36)
    private String idSesion;

    @Column(name = "cd_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "nb_usuario", nullable = false, length = 30)
    private String usuario;

    @Column(name = "nb_panta", nullable = false, length = 30)
    private String nombrePantalla;

    @Column(name = "tp_panta", nullable = false, length = 10)
    private String tipoPantalla;

    @Column(name = "fh_momento", nullable = false)
    private LocalDate fecha;

    @Column(name = "hr_momento", nullable = false)
    private LocalTime hora;

    @Column(name = "nb_bitac", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "cd_docum", nullable = false, length = 36)
    private String documento;

    public Bitacora() {
    }

    private Bitacora(Builder builder) {

        this.idSesion = builder.contexto.getIdSesion();
        this.usuario = builder.contexto.getUsuario();
        this.nombrePantalla = builder.contexto.getNombrePantalla();
        this.tipoPantalla = builder.contexto.getTipoPantalla();
        this.fecha = builder.momento.toLocalDate();
        this.hora = builder.momento.toLocalTime();
        this.descripcion = builder.descripcion;
        this.documento = builder.documento;

    }

    public static class Builder {

        private ContextoBitacora contexto;

        private LocalDateTime momento = LocalDateTime.now();

        private String documento;

        private String descripcion;

        private String codigo = "Builder";

        public Builder(ContextoBitacora contexto) throws BitacoraException {
            if (contexto == null) {
                throw new BitacoraException(codigo, "El contexto de la bitácora no puede ser vacío");
            }

            this.contexto = contexto;
        }

        public Builder documento(String documento) throws BitacoraException {
            if (documento == null || "".equalsIgnoreCase(documento)) {
                throw new BitacoraException(codigo, "El documento con el cual está relacionado el evento no puede ser vacío");
            }
            this.documento = documento;
            return this;
        }

        public Builder descripcion(String descripcion) throws BitacoraException {
            if (descripcion == null || "".equalsIgnoreCase(descripcion)) {
                throw new BitacoraException(codigo, "La descripción del evento no puede ser vacía");
            }
            this.descripcion = descripcion;
            return this;
        }

        public Bitacora build() {
            return new Bitacora(this);
        }
    }

    public static Builder of(ContextoBitacora context) throws BitacoraException {
        return new Builder(context);
    }

    public Long getId() {
        return id;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombrePantalla() {
        return nombrePantalla;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Bitacora)) {
            return false;
        }

        Bitacora other = (Bitacora) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Bitacora [idSesion=" + idSesion
                + ", usuario=" + usuario
                + ", momento=" + getFecha() + " " + getHora()
                + ", nombrePantalla=" + nombrePantalla
                + ", tipoPantalla=" + tipoPantalla
                + ", documento=" + documento
                + ", descripcion= " + descripcion + "]";
    }
}
