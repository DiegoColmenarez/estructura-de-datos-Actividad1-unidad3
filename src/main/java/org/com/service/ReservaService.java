package org.com.service;

public class ReservaService {
    private final ClienteRepository clienteRepo;
    private final ServicioRepository servicioRepo;
    private final ReservaRepository reservaRepo;

    public ReservaService(ClienteRepository clienteRepo, ServicioRepository servicioRepo, ReservaRepository reservaRepo) {
        this.clienteRepo = clienteRepo;
        this.servicioRepo = servicioRepo;
        this.reservaRepo = reservaRepo;
    }
}
