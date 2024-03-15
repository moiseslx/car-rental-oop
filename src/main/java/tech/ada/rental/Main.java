package tech.ada.rental;

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

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        ClienteService clienteService = new ClienteService(new ClienteRepositoryImpl());
//        System.out.println(clienteService.criar(new Cliente(
//                "Moises Almeida",
//                "moises@me.com",
//                "11 99999-9999",
//                "11111111111",
//                "11111111111",
//                TipoCliente.PESSOA_JURIDICA)));
//
//        VeiculoService veiculoService = new VeiculoService(new VeiculoRepositoryImpl());
//
//        var vrum = new Veiculo(TipoVeiculo.PEQUENO, "AAA-1111", "Fusca", "Volkswagen");
//        vrum.setDisponibilidade(false);
//
//        System.out.println(veiculoService.criar(vrum));
//        veiculoService.criar(new Veiculo(TipoVeiculo.SUV, "AAA-2222", "Golf", "Volkswagen"));
//        veiculoService.criar(new Veiculo(TipoVeiculo.PEQUENO, "AAA-3333", "Fusca", "Volkswagen"));
//
//        AluguelService aluguelService = new AluguelService(new AluguelRepositoryImpl());
//
//        System.out.println(aluguelService.criar(new Aluguel(clienteService.buscarPorId(0L),
//                veiculoService.buscarPorId(1L), LocalDateTime.now().minusDays(3).minusHours(1))));
//
//        System.out.println(aluguelService.devolverVeiculo(aluguelService.buscarPorId(0L)));
//
//        aluguelService.criar(new Aluguel(clienteService.buscarPorId(0L), veiculoService.buscarPorId(0L), LocalDateTime.now()));
    }
}