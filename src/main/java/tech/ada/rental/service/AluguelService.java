package tech.ada.rental.service;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.repository.AluguelRepository;
import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class AluguelService implements Service<Aluguel> {

    AluguelRepository repository;

    public AluguelService(AluguelRepository repository) {
        this.repository = repository;
    }
    @Override
    public Aluguel criar(Aluguel aluguel) throws VeiculoIndisponivelException {
        if (aluguel.getVeiculo().isDisponibilidade()) {
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
    public Iterable<Aluguel> buscarTodos() {
        return repository.findAll();
    }

    public Aluguel devolverVeiculo(Aluguel aluguel) {
        aluguel.getVeiculo().setDisponibilidade(true);
        aluguel.setDevolucao(LocalDateTime.now());
        aluguel.setPrecoAluguel(calcularAluguel(aluguel));
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
