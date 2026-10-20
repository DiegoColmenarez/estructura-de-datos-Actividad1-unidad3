package org.com.model;

import java.time.LocalDateTime;

public class Reserva implements Comparable<Reserva> {

    private Cliente cliente;
    private Servicio servicio;
    private LocalDateTime fecha;
    private NivelPrioridad prioridad;

    @Override
    public int compareTo(Reserva o) {
        return 0;
    }
}