package com.ferbo.bitacora.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ferbo.bitacora.exception.BitacoraException;
import com.ferbo.bitacora.model.Bitacora;
import com.ferbo.bitacora.model.FiltroBitacora;

public interface BitacoraDAO {

    EntityManager obtenerEntityManager();
    void cerrarEnitytManager(EntityManager em);
    void aplicarRollBack(EntityManager em);
    void mostrarInfo(String messsage);
    void mostrarWaring(String mensaje, Exception ex);
    void mostrarError(String mensaje, Exception ex);

    @SuppressWarnings("unchecked")
    public default List<Object[]> buscarGruposPorFiltros(FiltroBitacora filtros) throws BitacoraException { 
        EntityManager em = null;
        List<Object[]> resultados;

        try {
            em = obtenerEntityManager();

            resultados = em.createNamedQuery(
                    "Bitacora.findResumenByFiltros")
                    .setParameter("inicio", filtros.getInicio())
                    .setParameter("fin", filtros.getFin())
                    .setParameter("idUsuario", filtros.getIdUsuario())
                    .setParameter("nombrePantalla",
                            (filtros.getNombrePantalla() == null) ? null
                                    : filtros.getNombrePantalla())
                    .setParameter("tipoPantalla",
                            (filtros.getTipoPantalla() == null) ? null
                                    : filtros.getTipoPantalla())
                    .getResultList();

            return resultados;

        } catch (Exception ex) {
            mostrarWaring("Error al buscar grupos", ex);
            throw new BitacoraException("Persistencia", "Problema al buscar grupos de bitácora");
        } finally {
            cerrarEnitytManager(em);
        }
    }

    public default List<Bitacora> buscarPorFiltros(FiltroBitacora filtros) throws BitacoraException {
        EntityManager em = null;
        List<Bitacora> eventos;

        try {
            em = obtenerEntityManager();
            eventos = em.createNamedQuery("Bitacora.findByFiltros", Bitacora.class)
                    .setParameter("idUsuario", filtros.getIdUsuario())
                    .setParameter("usuario", filtros.getUsuario())
                    .setParameter("inicio", filtros.getInicio())
                    .setParameter("fin", filtros.getFin())
                    .setParameter("nombrePantalla", filtros.getNombrePantalla())
                    .setParameter("tipoPantalla", filtros.getTipoPantalla())
                    .setParameter("documento", filtros.getDocumento())
                    .getResultList();
            return eventos;
        } catch (Exception ex) {
            mostrarWaring("Error al buscar eventos de la bitácora por filtros", ex);
            throw new BitacoraException("Persistencia", "Hubo un problema al buscar los eventos de la bitacora con los filtros seleccionados");
        } finally {
            cerrarEnitytManager(em);
        }
    }
}
