package org.com.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva implements Comparable<Reserva> {

    private final String idReserva;
    private final Cliente cliente;
    private Servicio servicio;
    private LocalDateTime fecha;
    private NivelPrioridad prioridad;

    public Reserva(String idReserva, LocalDateTime fecha, Servicio servicio, Cliente cliente, NivelPrioridad prioridad) {
        controlFallos(idReserva);
        this.idReserva = idReserva.trim().toUpperCase();
        this.cliente = Objects.requireNonNull(cliente, "El cliente asociado a la reserva no puede ser nulo.");
        this.cambiarFecha(fecha);
        this.cambiarServicio(servicio);
        this.cambiarPrioridad(prioridad);
    }

    public void cambiarFecha(LocalDateTime nuevaFecha) {
        this.fecha = Objects.requireNonNull(nuevaFecha, "La fecha de la reserva no puede ser nula.");
    }

    public void cambiarServicio(Servicio nuevoServicio) {
        this.servicio = Objects.requireNonNull(nuevoServicio, "El servicio de la reserva no puede ser nulo.");
    }

    public void cambiarPrioridad(NivelPrioridad nuevaPrioridad) {
        this.prioridad = Objects.requireNonNull(nuevaPrioridad, "El nivel de prioridad no puede ser nulo.");
    }

    private void controlFallos(String idReserva){
        if (idReserva == null || idReserva.isBlank()) {
            throw new IllegalArgumentException("El código identificador de la reserva no puede estar vacío.");
        }
    }

    public String getIdReserva() { return idReserva; }
    public Cliente getCliente() { return cliente; }
    public Servicio getServicio() { return servicio; }
    public LocalDateTime getFecha() { return fecha; }
    public NivelPrioridad getPrioridad() { return prioridad; }

    @Override
    public int compareTo(Reserva o) {
        return 0;
    }
}