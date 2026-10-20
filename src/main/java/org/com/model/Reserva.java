package org.com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva implements Comparable<Reserva> {

    private  String idReserva;
    private Cliente cliente;
    private Servicio servicio;
    private LocalDateTime fecha;
    private NivelPrioridad prioridad;

    public void cambiarFecha(LocalDateTime nuevaFecha) {
        this.fecha = Objects.requireNonNull(nuevaFecha, "La fecha de la reserva no puede ser nula.");
    }

    public void cambiarServicio(Servicio nuevoServicio) {
        this.servicio = Objects.requireNonNull(nuevoServicio, "El servicio de la reserva no puede ser nulo.");
    }

    public void cambiarPrioridad(NivelPrioridad nuevaPrioridad) {
        this.prioridad = Objects.requireNonNull(nuevaPrioridad, "El nivel de prioridad no puede ser nulo.");
    }

    @Override
    public int compareTo(Reserva o) {
        return 0;
    }
}