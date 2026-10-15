package com.leonardoprogrammer.api.controller;

import com.leonardoprogrammer.api.enums.ApiVersao;
import com.leonardoprogrammer.api.model.dto.RequestClienteDTO;
import com.leonardoprogrammer.api.model.entity.Cliente;
import com.leonardoprogrammer.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApiVersao.V1 + "/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> criarCliente (@RequestBody @Valid RequestClienteDTO request) {

        Cliente newCliente = new Cliente();
        BeanUtils.copyProperties(request, newCliente);
        clienteService.save(newCliente);

        return new ResponseEntity<>("Cliente criado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> listarTodosClientes() {
        List<Cliente> clientes = clienteService.listarTodos();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Object> buscarClientePorId(@PathVariable UUID clienteId) {
        Cliente cliente = clienteService.buscarPorId(clienteId).orElse(null);

        if (cliente == null) {
            return new ResponseEntity<>("Não há cliente com este ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable UUID clienteId,
                                                   @RequestBody @Valid RequestClienteDTO request) {
        if (clienteId == null) {
            return new ResponseEntity<>("É necessário informar o ID do cliente", HttpStatus.BAD_REQUEST);
        }

        Cliente cliente = clienteService.buscarPorId(clienteId).orElse(null);
        if (cliente == null) {
            return new ResponseEntity<>("Cliente não encontrado com este ID", HttpStatus.BAD_REQUEST);
        }

        BeanUtils.copyProperties(request, cliente);
        clienteService.save(cliente);

        return new ResponseEntity<>("Cliente atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Object> deletarCliente(@PathVariable UUID clienteId) {
        if (!clienteService.existePorId(clienteId)) {
            return new ResponseEntity<>("Cliente não encontrado com este ID", HttpStatus.BAD_REQUEST);
        }

        clienteService.deletarPorId(clienteId);

        return new ResponseEntity<>("Cliente deletado com sucesso", HttpStatus.NO_CONTENT);
    }
}
