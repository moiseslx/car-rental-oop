package tech.ada.rental.service;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.AluguelRepository;
import tech.ada.rental.service.api.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class AluguelService implements Service<Cliente> {

    AluguelRepository repository;

    public AluguelService(AluguelRepository repository) {
        this.repository = repository;
    }


    public Aluguel devolverVeiculo(Aluguel aluguel) {
        aluguel.getVeiculo().setDisponibilidade(true);
        aluguel.setDevolucao(LocalDateTime.now());
        aluguel.setPrecoAluguel(calcularAluguel(aluguel));
        return repository.save(aluguel);
    }

    private BigDecimal calcularAluguel(Aluguel aluguel) {
        aluguel.setDevolucao(LocalDateTime.now());

        Duration duration = Duration.between(aluguel.getInicioAluguel(), aluguel.getDevolucao());

        if (duration.toHours() % 24 != 0) {
            duration = duration.plusDays(1);
        }

        long dias = duration.toDays();

        aluguel.setDiarias(dias);

        BigDecimal desconto = aluguel.getCliente().getTipo().calculoDesconto(aluguel);
        BigDecimal valorDiaria = aluguel.getVeiculo().getValorDiaria();

        BigDecimal valorTotal = valorDiaria.multiply(BigDecimal.valueOf(dias)).multiply(desconto);
        aluguel.setPrecoAluguel(valorTotal);

        return valorTotal;
    }

    @Override
    public Aluguel criar(Aluguel aluguel) {
        if (aluguel.getVeiculo().isDisponibilidade()) {
            aluguel.getVeiculo().setDisponibilidade(false);
            return repository.save(aluguel);
        }

        throw new RuntimeException("Veiculo indisponível");
    }

    @Override
    public Object atualizar(Object o) {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }
}
