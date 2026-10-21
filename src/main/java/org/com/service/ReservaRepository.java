package org.com.service;


import org.com.model.*;
import java.time.LocalDateTime;
import java.util.*;

public class ReservaRepository {
    private final Map<String, Reserva> mapaPorCodigo = new HashMap<>();
    private final Set<Reserva> arbolPorFecha = new TreeSet<>();
    private final Queue<Reserva> colaPorPrioridad = new PriorityQueue<>(Reserva.COMPARADOR_POR_PRIORIDAD);

    public boolean guardar(Reserva reserva) {
        if (mapaPorCodigo.containsKey(reserva.getIdReserva())) {
            return false;
        }
        mapaPorCodigo.put(reserva.getIdReserva(), reserva);
        arbolPorFecha.add(reserva);
        colaPorPrioridad.offer(reserva);
        return true;
    }

    public boolean eliminar(String codigo) {
        Reserva reserva = mapaPorCodigo.remove(codigo);
        if (reserva == null) return false;
        arbolPorFecha.remove(reserva);
        colaPorPrioridad.remove(reserva);
        return true;
    }

    public boolean actualizarFechaYPrioridad(String codigo, LocalDateTime nuevaFecha, NivelPrioridad nuevaPrioridad) {
        Reserva reserva = mapaPorCodigo.get(codigo);
        if (reserva == null) return false;
        arbolPorFecha.remove(reserva);
        colaPorPrioridad.remove(reserva);
        reserva.cambiarFecha(nuevaFecha);
        reserva.cambiarPrioridad(nuevaPrioridad);
        arbolPorFecha.add(reserva);
        colaPorPrioridad.offer(reserva);
        return true;
    }

    public Optional<Reserva> extraerSiguientePrioritaria() {
        Reserva masUrgente = colaPorPrioridad.poll();
        if (masUrgente != null) {
            mapaPorCodigo.remove(masUrgente.getIdReserva());
            arbolPorFecha.remove(masUrgente);
        }
        return Optional.ofNullable(masUrgente);
    }

    public Optional<Reserva> buscarPorCodigo(String codigo) {
        return Optional.ofNullable(mapaPorCodigo.get(codigo));
    }

}
