package org.com.service;

import org.com.model.Cliente;

public class ClienteService {
    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public boolean registrarCliente(Cliente cliente) {
        return clienteRepo.guardar(cliente);
    }
}
