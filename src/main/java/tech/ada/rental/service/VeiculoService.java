package tech.ada.rental.service;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.repository.VeiculoRepository;
import tech.ada.rental.repository.impl.VeiculoRepositoryImpl;
import java.util.List;

public class VeiculoService {
    VeiculoRepository repository = new VeiculoRepositoryImpl();

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo criar(Veiculo veiculo) {
        if (repository.findByPlaca(veiculo.getPlaca()) != null) {
            throw new RuntimeException("Ja existe um veículo com a placa informada no sistema");
        }

        return repository.save(veiculo);
    }

    public List<Veiculo> buscarPorNome(String nome){
        return repository.findByPartialName(nome);
    }


}
