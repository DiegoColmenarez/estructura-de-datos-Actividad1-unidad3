package org.com.service;

import org.com.model.Reserva;

public class ReservaService {
    private final ClienteRepository clienteRepo;
    private final ServicioRepository servicioRepo;
    private final ReservaRepository reservaRepo;

    public ReservaService(ClienteRepository clienteRepo, ServicioRepository servicioRepo, ReservaRepository reservaRepo) {
        this.clienteRepo = clienteRepo;
        this.servicioRepo = servicioRepo;
        this.reservaRepo = reservaRepo;
    }

    public boolean crearReserva(Reserva nueva) {
        if (!clienteRepo.existe(nueva.getCliente())) {
            throw new IllegalArgumentException("El cliente no está registrado.");
        }
        if (!servicioRepo.existe(nueva.getServicio())) {
            throw new IllegalArgumentException("El servicio no existe en el catálogo.");
        }
        return reservaRepo.guardar(nueva);
    }
}
