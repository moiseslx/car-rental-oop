package tech.ada.rental;

import tech.ada.rental.controller.AluguelController;
import tech.ada.rental.controller.ClienteController;
import tech.ada.rental.controller.VeiculoController;
import tech.ada.rental.dto.AluguelDTO;
import tech.ada.rental.dto.ClienteDTO;
import tech.ada.rental.dto.VeiculoDTO;
import tech.ada.rental.enums.TipoCliente;
import tech.ada.rental.enums.TipoVeiculo;
import tech.ada.rental.model.Aluguel;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.model.Veiculo;
import tech.ada.rental.repository.impl.AluguelRepositoryImpl;
import tech.ada.rental.repository.impl.ClienteRepositoryImpl;
import tech.ada.rental.repository.impl.VeiculoRepositoryImpl;
import tech.ada.rental.service.AluguelService;
import tech.ada.rental.service.ClienteService;
import tech.ada.rental.service.VeiculoService;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


    }
}