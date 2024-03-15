package tech.ada.rental.service;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.repository.VeiculoRepository;
import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;

import java.util.List;

public class VeiculoService implements Service<Veiculo> {
    VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }
    public Veiculo criar(Veiculo veiculo) throws ElementosDuplicadosException {
        if (repository.findByPlaca(veiculo.getPlaca()) == null) {
            veiculo.setValorDiaria(veiculo.getTipoVeiculo().definirValorDiaria(veiculo));
            return repository.save(veiculo);
        }

        throw new ElementosDuplicadosException("Ja existe um veículo com a placa informada");
    }
    public List<Veiculo> buscarPorNome(String nomeparcial){
        return repository.findByPartialName(nomeparcial);
    }
    public Veiculo buscarPorPlaca(String placa) throws ElementoNaoEncotradoException {
        if (repository.findByPlaca(placa) != null) {
            return repository.findByPlaca(placa);
        }

        throw new ElementoNaoEncotradoException("Placa nao encontrada");
    }

    public Veiculo buscarPorId(Long id) throws ElementoNaoEncotradoException{
        if (repository.findById(id) != null){
            return repository.findById(id);
        }

        throw new ElementoNaoEncotradoException("Veiculo nao encontrado");
    }

    @Override
    public Iterable<Veiculo> buscarTodos() {
        return repository.findAll();
    }

    public Veiculo atualizar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public void deletar(Long id) throws ElementoNaoEncotradoException {
        if (repository.findById(id) != null){
            repository.deleteById(id);
        }

        throw new ElementoNaoEncotradoException("Veiculo para deletar nao encontrado");
    }
}
