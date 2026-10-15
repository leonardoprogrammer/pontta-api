package com.leonardoprogrammer.api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    @Size(min = 3)
    private String nome;

    private String endereco;

    public Cliente() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
