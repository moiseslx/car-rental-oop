package tech.ada.rental.dto;

import tech.ada.rental.enums.TipoCliente;
import tech.ada.rental.model.Cliente;

public record ClienteDTO(String nome, String email, String telefone, String documento, String cnh, TipoCliente tipo) {

    public Cliente toCliente() {
        return new Cliente(nome, email, telefone, documento, cnh, tipo);
    }
}

