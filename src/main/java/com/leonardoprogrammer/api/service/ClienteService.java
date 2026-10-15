package com.leonardoprogrammer.api.service;

import com.leonardoprogrammer.api.model.entity.Cliente;
import com.leonardoprogrammer.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteRepository.findById(id);
    }

    public boolean existePorId(UUID id) {
        return clienteRepository.existsById(id);
    }

    public void deletarPorId(UUID id) {
        clienteRepository.deleteById(id);
    }
}
