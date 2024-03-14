package tech.ada.rental.service;

import org.jetbrains.annotations.NotNull;
import tech.ada.rental.model.Veiculo;
import tech.ada.rental.repository.VeiculoRepository;
import tech.ada.rental.repository.impl.VeiculoRepositoryImpl;
import java.util.List;

public class VeiculoService {
    VeiculoRepository repository = new VeiculoRepositoryImpl();

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }
    public Veiculo criar(@NotNull Veiculo veiculo) {
        if (repository.findByPlaca(veiculo.getPlaca()) != null) {
            // TODO: Implementar tratamento de erros
            throw new RuntimeException("Ja existe um veículo com a placa informada no sistema");
        }
        veiculo.setValorDiaria(veiculo.getTipoVeiculo().definirValorDiaria(veiculo));
        return repository.save(veiculo);
    }
    public List<Veiculo> buscarPorNome(String nomeparcial){
        return repository.findByPartialName(nomeparcial);
    }
    public Veiculo buscarPorPlaca(String placa){
        return repository.findByPlaca(placa);
    }

    public Veiculo buscarPorId(Long id){
        return repository.findById(id);
    }
    public Veiculo atualizar(Veiculo veiculo) {
        return repository.save(veiculo);
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
