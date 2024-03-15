package tech.ada.rental.controller;

import tech.ada.rental.controller.reponse.ResponseEntity;
import tech.ada.rental.dto.ClienteDTO;
import tech.ada.rental.enums.RequestStatus;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.ClienteService;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.controller.validators.UserEntryValidator;

public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ResponseEntity<Cliente> criar(ClienteDTO clienteDTO){
        ResponseEntity<Cliente> response = new ResponseEntity<>();

        if (!UserEntryValidator.validateDocumento(clienteDTO.documento())){
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("Documento invalido");
            return response;
        }

        if (!UserEntryValidator.validateNome(clienteDTO.nome())){
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("Nome invalido");
            return response;
        }

        if (!UserEntryValidator.validarCNH(clienteDTO.cnh())){
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("CNH invalida");
            return response;
        }

        try {
            response.setData(clienteService.criar(clienteDTO.toCliente()));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Cliente criado com sucesso");
            return response;
        } catch (ElementosDuplicadosException e) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage(e.getMessage());
            return response;
        }
    }
}
