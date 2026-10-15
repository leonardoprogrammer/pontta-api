package com.leonardoprogrammer.api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RequestClienteDTO {

    @NotBlank
    @Size(min = 3)
    private String nome;

    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
