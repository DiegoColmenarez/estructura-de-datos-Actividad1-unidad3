package org.com.model;

public record Servicio(String nombreTipo) {

    public Servicio {
        controlFallos(nombreTipo);
        nombreTipo = nombreTipo.trim().toUpperCase();
    }

    private void controlFallos(String nombreTipo){
        if (nombreTipo == null || nombreTipo.isBlank()) {
            throw new IllegalArgumentException("El nombre o tipo de servicio no puede ser nulo ni vacío.");
        }
    }

    @Override
    public String toString() {
        return nombreTipo;
    }
}