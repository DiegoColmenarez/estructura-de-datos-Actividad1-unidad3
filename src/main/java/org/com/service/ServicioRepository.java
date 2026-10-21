package org.com.service;

import org.com.model.Servicio;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ServicioRepository {
    private final List<Servicio> servicios = new ArrayList<>();

    public boolean guardar(Servicio servicio) {
        if (servicios.contains(servicio)) return false;
        return servicios.add(servicio);
    }

    public boolean existe(Servicio servicio) {
        return servicios.contains(servicio);
    }

    public Collection<Servicio> listarTodos() {
        return Collections.unmodifiableList(servicios);
    }
}
