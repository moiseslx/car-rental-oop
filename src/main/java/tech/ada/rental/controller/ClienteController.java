package tech.ada.rental.controller;

import tech.ada.rental.controller.reponse.ResponseEntity;
import tech.ada.rental.dto.ClienteDTO;
import tech.ada.rental.enums.RequestStatus;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.ClienteService;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
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

        if (!UserEntryValidator.validateEmail(clienteDTO.email())){
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("E-mail invalido");
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

    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return new ResponseEntity<>(clienteService.buscarTodos(), RequestStatus.SUCCESS, "Busca realizada com sucesso");
    }

    public ResponseEntity<Cliente> buscarPorId(Long id){
        try {
            return new ResponseEntity<>(clienteService.buscarPorId(id), RequestStatus.SUCCESS, "Busca realizada com sucesso");
        } catch (ElementoNaoEncotradoException e) {
            return new ResponseEntity<>(null, RequestStatus.NOT_FOUND, e.getMessage());
        }
    }

    public ResponseEntity<Cliente> buscarPorDocumento(String documento){
        try {
            return new ResponseEntity<>(clienteService.buscarPorDocumento(documento), RequestStatus.SUCCESS, "Busca realizada com sucesso");
        } catch (ElementoNaoEncotradoException e) {
            return new ResponseEntity<>(null, RequestStatus.NOT_FOUND, e.getMessage());
        }
    }

    public ResponseEntity<Cliente> atualizar(ClienteDTO clienteDTO){
        ResponseEntity<Cliente> response = new ResponseEntity<>();
        try {
            response.setData(clienteService.atualizar(clienteDTO.toCliente()));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Cliente atualizado com sucesso");
            return response;
        } catch (ElementoNaoEncotradoException e) {
            response.setStatus(RequestStatus.NOT_FOUND);
            response.setMessage(e.getMessage());
            return response;
        }
    }

}
