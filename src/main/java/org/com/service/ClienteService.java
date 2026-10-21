package org.com.service;

import org.com.model.Cliente;
import java.util.Optional;

public class ClienteService {
    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public boolean registrarCliente(Cliente cliente) {
        return clienteRepo.guardar(cliente);
    }

    public Optional<Cliente> buscarPorId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del cliente no puede estar vacío.");
        }
        return clienteRepo.buscarPorId(id.trim().toUpperCase());
    }
}
