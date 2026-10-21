package org.com.service;

import org.com.model.Servicio;

public class ServicioService {
    private final ServicioRepository servicioRepo;

    public ServicioService(ServicioRepository servicioRepo) {
        this.servicioRepo = servicioRepo;
    }

    public boolean registrarServicio(Servicio servicio) {
        return servicioRepo.guardar(servicio);
    }


}
