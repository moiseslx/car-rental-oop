package tech.ada.rental.service;

import tech.ada.rental.enums.AluguelStatus;
import tech.ada.rental.model.Aluguel;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.AluguelRepository;
import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelService implements Service<Aluguel> {

    AluguelRepository repository;
    ClienteService clienteService;
    VeiculoService veiculoService;

    public AluguelService(AluguelRepository repository, ClienteService clienteService, VeiculoService veiculoService) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
    }
    @Override
    public Aluguel criar(Aluguel aluguel) throws VeiculoIndisponivelException, ElementoNaoEncotradoException {
        if(clienteService.buscarPorId(aluguel.getCliente().getId()) != null && veiculoService.buscarPorId(aluguel.getVeiculo().getId()) != null && aluguel.getVeiculo().isDisponibilidade()) {
                aluguel.setStatus(AluguelStatus.EM_ANDAMENTO);
                aluguel.getVeiculo().setDisponibilidade(false);
                return repository.save(aluguel);
        }

        throw new VeiculoIndisponivelException("Veiculo indisponível");
    }

    @Override
    public Aluguel atualizar(Aluguel aluguel) {
        return repository.save(aluguel);
    }

    @Override
    public void deletar(Long id) throws ElementoNaoEncotradoException {
        if (repository.findById(id) != null) {
            repository.deleteById(id);
        } else {
            throw new ElementoNaoEncotradoException("Aluguel não encontrado");
        }
    }

    @Override
    public Aluguel buscarPorId(Long id) throws ElementoNaoEncotradoException {
        if (repository.findById(id) != null) {
            return repository.findById(id);
        }

        throw new ElementoNaoEncotradoException("Aluguel não encontrado");
    }

    @Override
    public List<Aluguel> buscarTodos() {
        return repository.findAll();
    }

    public List<Aluguel> buscarPorCliente (Cliente cliente) throws ElementoNaoEncotradoException {
        if (repository.findAll().stream().filter(aluguel -> aluguel.getCliente().equals(cliente)).collect(Collectors.toList()).isEmpty()) {
            throw new ElementoNaoEncotradoException("Cliente não possui alugueis");
        }
        return repository.findAll().stream().filter(aluguel -> aluguel.getCliente().equals(cliente)).collect(Collectors.toList());
    }

    public Aluguel devolverVeiculo(Aluguel aluguel) {
        aluguel.getVeiculo().setDisponibilidade(true);
        aluguel.setDevolucao(LocalDateTime.now());
        aluguel.setPrecoAluguel(calcularAluguel(aluguel));
        aluguel.setStatus(AluguelStatus.FINALIZADO);
        return repository.save(aluguel);
    }

    private BigDecimal calcularAluguel(Aluguel aluguel) {
        aluguel.setDevolucao(LocalDateTime.now());
        aluguel.setDiarias(obterDiarias(aluguel));
        aluguel.setPrecoAluguel(obterValorTotal(aluguel));
        return aluguel.getPrecoAluguel();
    }

    private Long obterDiarias(Aluguel aluguel) {
        Duration duration = Duration.between(aluguel.getInicioAluguel(), aluguel.getDevolucao());

        if (duration.toHours() % 24 != 0) {
            duration = duration.plusDays(1);
        }

        return duration.toDays();
    }

    private BigDecimal obterValorTotal(Aluguel aluguel) {
        return aluguel
                .getVeiculo()
                .getValorDiaria()
                .multiply(BigDecimal.valueOf(aluguel.getDiarias()))
                .multiply(aluguel.getCliente().getTipo().calculoDesconto(aluguel));
    }
}
