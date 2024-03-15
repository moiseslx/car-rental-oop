package tech.ada.rental.controller;

import tech.ada.rental.controller.reponse.ResponseEntity;
import tech.ada.rental.controller.validators.UserEntryValidator;
import tech.ada.rental.dto.ClienteDTO;
import tech.ada.rental.dto.VeiculoDTO;
import tech.ada.rental.enums.RequestStatus;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.model.Veiculo;
import tech.ada.rental.service.VeiculoService;
import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;

import java.util.List;

public class VeiculoController {

    VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public ResponseEntity<Veiculo> criar(VeiculoDTO veiculoDTO) {
        ResponseEntity<Veiculo> response = new ResponseEntity<>();

        if (!UserEntryValidator.validatePlaca(veiculoDTO.placa())) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("Placa invalida");
            return response;
        }

        try {
            response.setData(veiculoService.criar(veiculoDTO.toVeiculo()));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Veiculo criado com sucesso");
            return response;
        } catch (ElementosDuplicadosException e) {
            response.setStatus(RequestStatus.CONFLICT);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    public ResponseEntity<Veiculo> alterar(VeiculoDTO veiculoDTO) {
        ResponseEntity<Veiculo> response = new ResponseEntity<>();

        if (!UserEntryValidator.validatePlaca(veiculoDTO.placa())) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("Placa invalida");
            return response;
        }
        try {
            response.setData(veiculoService.atualizar(veiculoDTO.toVeiculo()));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Veiculo alterado com sucesso");
            return response;
        } catch (ElementoNaoEncotradoException e) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    public ResponseEntity<Veiculo> buscarPorPlaca(String placa) {
        ResponseEntity<Veiculo> response = new ResponseEntity<>();
        try {
            response.setData(veiculoService.buscarPorPlaca(placa));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Veículo encontrado");
            return response;
        } catch (ElementoNaoEncotradoException e) {
            response.setStatus(RequestStatus.NOT_FOUND);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    public ResponseEntity<Veiculo> buscarPorId(Long id) {
        ResponseEntity<Veiculo> response = new ResponseEntity<>();
        try {
            response.setData(veiculoService.buscarPorId(id));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Veículo encontrado");
            return response;
        } catch (ElementoNaoEncotradoException e) {
            response.setStatus(RequestStatus.NOT_FOUND);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    public ResponseEntity<List<Veiculo>> buscarPorNome(String nomeparcial) {
        ResponseEntity<List<Veiculo>> response = new ResponseEntity<>();
        try {
            response.setData(veiculoService.buscarPorNome(nomeparcial));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Veiculos encontrados");
            return response;
        } catch (ElementoNaoEncotradoException e) {
            response.setStatus(RequestStatus.NOT_FOUND);
            response.setMessage(e.getMessage());
            return response;
        }
    }

    public ResponseEntity<Iterable<Veiculo>> buscarTodos() {
        ResponseEntity<Iterable<Veiculo>> response = new ResponseEntity<>();
        try {
            response.setData(veiculoService.buscarTodos());
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Veiculos encontrados");
            return response;
        } catch (ElementoNaoEncotradoException e) {
            response.setStatus(RequestStatus.NOT_FOUND);
            response.setMessage(e.getMessage());
            return response;
        }
    }
}


