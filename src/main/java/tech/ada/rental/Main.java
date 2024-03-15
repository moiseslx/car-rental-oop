package tech.ada.rental;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.repository.AluguelRepository;
import tech.ada.rental.repository.impl.AluguelRepositoryImpl;
import tech.ada.rental.repository.impl.ClienteRepositoryImpl;
import tech.ada.rental.repository.impl.VeiculoRepositoryImpl;
import tech.ada.rental.service.AluguelService;
import tech.ada.rental.service.ClienteService;
import tech.ada.rental.service.VeiculoService;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService(new ClienteRepositoryImpl());
        VeiculoService veiculoService = new VeiculoService(new VeiculoRepositoryImpl());
        AluguelService aluguelService = new AluguelService(new AluguelRepositoryImpl(), clienteService, veiculoService);

        try {
            aluguelService.criar(new Aluguel(clienteService.buscarPorId(1L), veiculoService.buscarPorId(1L), LocalDateTime.now()));
        } catch (VeiculoIndisponivelException | ElementoNaoEncotradoException e) {
            System.err.println(e.getMessage());
        }
    }
}