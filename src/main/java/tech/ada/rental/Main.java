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

        ClienteService clienteService = new ClienteService(new ClienteRepositoryImpl());
        VeiculoService veiculoService = new VeiculoService(new VeiculoRepositoryImpl());
        AluguelService aluguelService = new AluguelService(new AluguelRepositoryImpl(), clienteService, veiculoService);
        AluguelController aluguelController = new AluguelController(aluguelService);
        ClienteController clienteController = new ClienteController(clienteService);
        VeiculoController veiculoController = new VeiculoController(veiculoService);

        // TESTANDO FUNCIONALIDADES

        // CRIAR CLIENTES
        clienteController.criar(new ClienteDTO("João Silva", "joao@gmail.com", "(123) 456-7890", "12345678911", "AB123456789", TipoCliente.PESSOA_FISICA));
        clienteController.criar(new ClienteDTO("Maria Oliveira", "maria@yahoo.com", "(987) 654-3210", "09876543210", "RJ309876500", TipoCliente.PESSOA_JURIDICA));
        clienteController.criar(new ClienteDTO("Pedro Santos", "pedro@hotmail.com", "(555) 555-5555", "13579246800", "SP680135700", TipoCliente.PESSOA_FISICA));
        clienteController.criar(new ClienteDTO("Ana Souza", "ana@aol.com", "(111) 222-3333", "86420975300", "CE579246801", TipoCliente.PESSOA_JURIDICA));
        clienteController.criar(new ClienteDTO("Carlos Pereira", "carlos@outlook.com", "(999) 888-7777", "98765432101", "RS345678901", TipoCliente.PESSOA_FISICA));
        clienteController.criar(new ClienteDTO("Mariana Ferreira", "mariana@icloud.com", "(777) 666-5555", "13579246802", "MG680135701", TipoCliente.PESSOA_JURIDICA));
        // Tentando criar cliente com documento duplicado
        System.out.println(clienteController.criar(new ClienteDTO("Pedro Santos", "pedro@hotmail.com", "(555) 555-5555", "13579246800", "PE680135700", TipoCliente.PESSOA_FISICA)));
        // Tentando criar cliente com dados inválidos
        System.out.println(clienteController.criar(new ClienteDTO("Pe", "pedro@hotmail.com", "(555) 555-5555", "13579246800", "PE680135700", TipoCliente.PESSOA_FISICA)));
        System.out.println(clienteController.criar(new ClienteDTO("Pedro Santos", "pedro@hotmail.com", "(555) 555-5555", "1357", "PE680135700", TipoCliente.PESSOA_FISICA)));
        System.out.println(clienteController.criar(new ClienteDTO("Pedro Santos", "pedro@hotmail.com", "(555) 555-5555", "13579246800", "PE65700", TipoCliente.PESSOA_FISICA)));
        System.out.println(clienteController.criar(new ClienteDTO("Pedro Santos", "pedro.com", "(555) 555-5555", "13579246800", "PE680135700", TipoCliente.PESSOA_FISICA)));


        // FUNCIONALIDADES DE BUSCA
        System.out.println(clienteController.buscarTodos());
        System.out.println(clienteController.buscarPorId(1L));
        System.out.println(clienteController.buscarPorDocumento("12345678911"));

        // FUNCIONALIDADES DE ATUALIZACAO
        System.out.println(clienteController.buscarPorId(0L));
        clienteController.atualizar(new ClienteDTO("João Silva", "joao_silva@gmail.com", "(123) 456-7890", "12345678911", "AB123456789", TipoCliente.PESSOA_FISICA));
        System.out.println(clienteController.buscarPorId(0L));

        // CRIAR VEÍCULOS
        veiculoController.criar(new VeiculoDTO(TipoVeiculo.PEQUENO, "ABC-1234", "Gol", "Volkswagen"));
        veiculoController.criar(new VeiculoDTO(TipoVeiculo.PEQUENO, "ABC-0000", "Golf", "Volkswagen"));
        veiculoController.criar(new VeiculoDTO(TipoVeiculo.MEDIO, "DEF-5678", "Corolla", "Toyota"));
        veiculoController.criar(new VeiculoDTO(TipoVeiculo.SUV, "GHI-9012", "Ecosport", "Ford"));
        veiculoController.criar(new VeiculoDTO(TipoVeiculo.PEQUENO, "JKL-3456", "Uno", "Fiat"));
        veiculoController.criar(new VeiculoDTO(TipoVeiculo.MEDIO, "MNO-7890", "Civic", "Honda"));
        // Tentando criar cliente com mesma placa
        System.out.println(veiculoController.criar(new VeiculoDTO(TipoVeiculo.PEQUENO, "JKL-3456", "Uno", "Fiat")));

        // FUNCIONALIDADES DE BUSCA
        System.out.println(veiculoController.buscarTodos());
        System.out.println(veiculoController.buscarPorId(1L));
        System.out.println(veiculoController.buscarPorPlaca("ABC-1234"));
        System.out.println(veiculoController.buscarPorNome("Gol"));

        // CRIAR ALUGUEL
        System.out.println(aluguelController.realizarAluguel(new AluguelDTO(clienteController.buscarPorId(0L).getData(), veiculoController.buscarPorId(0L).getData(), LocalDateTime.now().minusDays(2L))));
        System.out.println(aluguelController.realizarAluguel(new AluguelDTO(clienteController.buscarPorId(1L).getData(), veiculoController.buscarPorId(1L).getData(), LocalDateTime.now().minusDays(2L))));
        System.out.println(aluguelController.realizarAluguel(new AluguelDTO(clienteController.buscarPorId(2L).getData(), veiculoController.buscarPorId(2L).getData(), LocalDateTime.now().minusDays(6L))));
        System.out.println(aluguelController.realizarAluguel(new AluguelDTO(clienteController.buscarPorId(3L).getData(), veiculoController.buscarPorId(3L).getData(), LocalDateTime.now().minusDays(4L))));

        // Tentando alugar carro alugado
        System.out.println(aluguelController.realizarAluguel(new AluguelDTO(clienteController.buscarPorId(3L).getData(), veiculoController.buscarPorId(3L).getData(), LocalDateTime.now().minusDays(4L))));

        // FUNCIONALIDADES DE BUSCA
        System.out.println(aluguelController.buscarPorId(0L).getMessage());
        System.out.println(aluguelController.buscarPorId(1L).getData());
        System.out.println(aluguelController.buscarPorId(2L).getMessage());
        System.out.println(aluguelController.buscarPorId(03L));
        System.out.println(aluguelController.buscarPorId(4L).getMessage());


        // DEVOLUÇÃO DE ALUGUEL
        aluguelController.finalizarAluguel(aluguelController.buscarPorId(0L).getData());
        System.out.println(aluguelController.buscarPorId(0l).getData().getPrecoAluguel());
        aluguelController.finalizarAluguel(aluguelController.buscarPorId(1L).getData());
        System.out.println(aluguelController.buscarPorId(1l).getData().getPrecoAluguel());

        // Testando descontos para pf e pj
        aluguelController.finalizarAluguel(aluguelController.buscarPorId(2L).getData());
        System.out.println(aluguelController.buscarPorId(2l).getData().getPrecoAluguel());
        aluguelController.finalizarAluguel(aluguelController.buscarPorId(3L).getData());
        System.out.println(aluguelController.buscarPorId(3l).getData().getPrecoAluguel());
    }
}