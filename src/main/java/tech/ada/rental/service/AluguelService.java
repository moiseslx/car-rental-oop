package tech.ada.rental.service;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.repository.AluguelRepository;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class AluguelService {

    AluguelRepository repository;

    public AluguelService(AluguelRepository repository) {
        this.repository = repository;
    }

    public Aluguel criarAluguel(Aluguel aluguel) throws VeiculoIndisponivelException {
        if (aluguel.getVeiculo().isDisponibilidade()) {
            aluguel.getVeiculo().setDisponibilidade(false);
            return repository.save(aluguel);
        }

        throw new VeiculoIndisponivelException("Veiculo indisponível");
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

    public Aluguel buscarPorId(long l) throws ElementoNaoEncotradoException {
        if (repository.findById(l) != null) {
            return repository.findById(l);
        }

        throw new ElementoNaoEncotradoException("Aluguel não encontrado");
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
