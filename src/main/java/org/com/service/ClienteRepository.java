package org.com.service;

import org.com.model.Cliente;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ClienteRepository {
    private final Set<Cliente> clientes = new HashSet<>();

    public boolean guardar(Cliente cliente) {
        return clientes.add(cliente);
    }

    public boolean existe(Cliente cliente) {
        return clientes.contains(cliente);
    }

    public Optional<Cliente> buscarPorId(String idCliente) {
        return clientes.stream()
                .filter(c -> c.getIdCliente().equals(idCliente))
                .findFirst();
    }
}
