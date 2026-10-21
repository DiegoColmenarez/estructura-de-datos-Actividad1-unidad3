package org.com.service;

import org.com.model.Reserva;
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
}
