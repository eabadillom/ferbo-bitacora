package com.ferbo.bitacora.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ferbo.bitacora.dto.BitacoraDTO;
import com.ferbo.bitacora.exception.BitacoraException;
import com.ferbo.bitacora.model.Bitacora;
import com.ferbo.bitacora.model.ContextoBitacora;
import com.ferbo.bitacora.model.FiltroBitacora;

public interface BitacoraBL {

    void guardarEvento(Bitacora eventoBitacora) throws BitacoraException;

    List<Bitacora> buscarPorFiltrosImp(FiltroBitacora filtros) throws BitacoraException;

    List<Object[]> buscarGruposPorFiltrosImp(FiltroBitacora filtros) throws BitacoraException;

    List<String> tiposPantallaEnumToList();

    List<String> nombresPantallaEnumToList();

    LocalDate obtenerMomentoBicatoraFormateado(BitacoraDTO dto);

    Optional<byte[]> exportToFile(FiltroBitacora filtros, String extension) throws BitacoraException;

    void mostrarInfo(String messsage);
    void mostrarWaring(String mensaje, Exception ex);
    void mostrarError(String mensaje, Exception ex);

    public default void registrarEnBitacora(List<Bitacora> eventos) throws BitacoraException {

        for (int i = 0; i < eventos.size(); i++) {
            guardarEvento(eventos.get(i));
            mostrarInfo("Se registro el evento: " + eventos.get(i));
        }

    }

    public default List<Bitacora> obtenerPorFiltros(BitacoraDTO dto) throws BitacoraException {
        if (dto == null) {
            throw new BitacoraException("Lógica", "El grupo seleccionado no puede ser vacío");
        }
        FiltroBitacora filtros = dtoToFiltro(dto);
        return buscarPorFiltrosImp(filtros);

    }

    public default List<BitacoraDTO> obtenerGruposPorFiltros(FiltroBitacora filtros) {
        List<BitacoraDTO> grupos = new ArrayList<>();
        List<Object[]> resulsados = buscarGruposPorFiltrosImp(filtros);
        if (resulsados.isEmpty()) {
            return grupos;
        }
        return listResultSetToDTO(resulsados);

    }

    public default void agregarORemplazarSiExiste(
            List<Bitacora> eventos,
            ContextoBitacora context,
            String descripcion,
            String documento) throws BitacoraException {

        int index = 0;

        Bitacora evento = Bitacora.of(context)
                .documento(documento)
                .descripcion(descripcion)
                .build();

        if (eventos.isEmpty()) {
            eventos.add(evento);
        } else {
            eventos.set(index, evento);
        }
    }

    public default List<BitacoraDTO> listResultSetToDTO(List<Object[]> resultados) {
        List<BitacoraDTO> eventos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            BitacoraDTO evento = new BitacoraDTO();
            evento.setDocumento((String) resultado[0]);
            evento.setIdUsuario(((Number) resultado[1]).intValue());
            evento.setUsuario((String) resultado[2]);
            evento.setNombrePantalla((String) resultado[3]);
            evento.setTipoPantalla((String) resultado[4]);
            evento.setMomento((Date) resultado[5]);

            eventos.add(evento);
        }
        return eventos;
    }

    public default FiltroBitacora dtoToFiltro(BitacoraDTO dto) {
        FiltroBitacora filtros = new FiltroBitacora();

        LocalDate momento = obtenerMomentoBicatoraFormateado(dto);

        filtros.setInicio(momento);
        filtros.setFin(momento);

        filtros.setIdUsuario(dto.getIdUsuario());
        filtros.setDocumento(dto.getDocumento());

        List<String> tiposPantalla = tiposPantallaEnumToList();
        List<String> nombresPantalla = nombresPantallaEnumToList();

        for (String tipoPantalla : tiposPantalla) {
            if (dto.getTipoPantalla().equalsIgnoreCase(tipoPantalla)) {
                filtros.setTipoPantalla(tipoPantalla);
            }
        }

        for (String nombrePantalla : nombresPantalla) {
            if (dto.getNombrePantalla().equalsIgnoreCase(nombrePantalla)) {
                filtros.setNombrePantalla(nombrePantalla);
            }
        }

        return filtros;
    }

    public default void limpiarEventos(List<Bitacora> evetos) {
        evetos.clear();
        evetos = new ArrayList<>();
    }
}
