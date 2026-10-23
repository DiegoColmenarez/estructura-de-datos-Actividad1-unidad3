package org.com.service;

import org.com.model.Servicio;
import java.util.Collection;

public class ServicioService {
    private final ServicioRepository servicioRepo;

    public ServicioService(ServicioRepository servicioRepo) {
        this.servicioRepo = servicioRepo;
    }

    public boolean registrarServicio(Servicio servicio) {
        return servicioRepo.guardar(servicio);
    }

    public Collection<Servicio> listarCatalogo() {
        return servicioRepo.listarTodos();
    }
}
