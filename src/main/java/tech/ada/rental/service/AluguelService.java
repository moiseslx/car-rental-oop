package tech.ada.rental.service;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.repository.AluguelRepository;
import tech.ada.rental.repository.impl.AluguelRepositoryImpl;

public class AluguelService {

    AluguelRepository repository = new AluguelRepositoryImpl();

    public AluguelService(AluguelRepository repository) {
        this.repository = repository;
    }

    public Aluguel criarAluguel(Aluguel aluguel) {
        aluguel.getVeiculo().setDisponibilidade(false);
        return repository.save(aluguel);
    }
}
