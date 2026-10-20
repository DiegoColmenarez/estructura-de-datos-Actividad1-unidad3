package org.com.model;

import java.util.Objects;

public class Cliente {
    private final String idCliente;
    private String nombreCompleto;
    private String email;

    public Cliente(String idCliente, String nombreCompleto, String email) {
        controlFallos(idCliente);
        this.idCliente = idCliente.trim().toUpperCase();
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
        this.email = Objects.requireNonNull(email);
    }

    private void controlFallos(String idCliente){
        if (idCliente == null || idCliente.isBlank()) {
            throw new IllegalArgumentException("El ID del cliente es obligatorio.");
        }
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getNombreCompleto() {return nombreCompleto;}
    public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;}

    public String getIdCliente() {return idCliente;}

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cliente cliente = (Cliente) object;
        return Objects.equals(idCliente, cliente.idCliente);
    }
}
