package com.leonardoprogrammer.api.repository;

import com.leonardoprogrammer.api.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
