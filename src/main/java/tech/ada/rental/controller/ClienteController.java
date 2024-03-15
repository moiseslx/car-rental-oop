package tech.ada.rental.controller;

import tech.ada.rental.dto.ClienteDTO;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.ClienteService;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.controller.validators.UserEntryValidator;

public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente criar(ClienteDTO clienteDTO) throws ElementosDuplicadosException {
        // TODO validar entrada de dados
        boolean documentoValido = UserEntryValidator.validateDocumento(clienteDTO.documento());
        boolean nomeValido = UserEntryValidator.validateNome(clienteDTO.nome());
        boolean cnhValida = UserEntryValidator.validarCNH(clienteDTO.cnh());
        return clienteService.criar(clienteDTO.toCliente());
    }
}
