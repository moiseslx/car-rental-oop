package tech.ada.rental.controller;

import tech.ada.rental.controller.reponse.ResponseEntity;
import tech.ada.rental.controller.validators.UserEntryValidator;
import tech.ada.rental.dto.AluguelDTO;
import tech.ada.rental.enums.RequestStatus;
import tech.ada.rental.model.Aluguel;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.AluguelService;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.util.List;

public class AluguelController {

    AluguelService aluguelService;

    public AluguelController (AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public ResponseEntity<Aluguel> realizarAluguel(AluguelDTO aluguelDTO) {
        ResponseEntity<Aluguel> response = new ResponseEntity<>();

        if (aluguelDTO.cliente() == null) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("O cliente deve ser informado");
            return response;
        }

        if (aluguelDTO.veiculo() == null) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("O veiculo deve ser informado");
            return response;
        }

        if (!UserEntryValidator.validateDate(String.valueOf(aluguelDTO.inicioAluguel()))) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage("A data de inicio do aluguel deve ser informada");
            return response;
        }

        try {
            response.setData(aluguelService.criar(aluguelDTO.toAluguel()));
            response.setStatus(RequestStatus.SUCCESS);
            response.setMessage("Cliente criado com sucesso");
            return response;
        } catch (ElementoNaoEncotradoException | VeiculoIndisponivelException e) {
            response.setStatus(RequestStatus.BAD_REQUEST);
            response.setMessage(e.getMessage());
            return response;
        }

    }

    public ResponseEntity<Iterable<Aluguel>> buscarTodos() {
        return new ResponseEntity<>(aluguelService.buscarTodos(), RequestStatus.SUCCESS, "Busca realizada com sucesso");
    }

    public ResponseEntity<Aluguel> buscarPorId(Long id) {
        try {
            return new ResponseEntity<>(aluguelService.buscarPorId(id), RequestStatus.SUCCESS, "Busca realizada com sucesso");
        } catch (ElementoNaoEncotradoException e) {
            return new ResponseEntity<>(null, RequestStatus.NOT_FOUND, e.getMessage());
        }
    }

    public ResponseEntity<List<Aluguel>> buscarPorCliente(Cliente cliente) {
        try {
            return new ResponseEntity<>(aluguelService.buscarPorCliente(cliente), RequestStatus.SUCCESS, "Busca realizada com sucesso");
        } catch (ElementoNaoEncotradoException e) {
            return new ResponseEntity<>(null, RequestStatus.NOT_FOUND, e.getMessage());
        }
    }
    public ResponseEntity<Aluguel> atualizar(AluguelDTO aluguelDTO) {
        ResponseEntity<Aluguel> response = new ResponseEntity<>();
        response.setData(aluguelService.atualizar(aluguelDTO.toAluguel()));
        response.setStatus(RequestStatus.SUCCESS);
        response.setMessage("Aluguel atualizado com sucesso");
        return response;
    }

    public ResponseEntity<Aluguel> finalizarAluguel(Aluguel aluguel) {
        ResponseEntity<Aluguel> response = new ResponseEntity<>();
        response.setData(aluguelService.devolverVeiculo(aluguel));
        response.setStatus(RequestStatus.SUCCESS);
        response.setMessage("Aluguel finalizado com sucesso");
        return response;
    }
}
