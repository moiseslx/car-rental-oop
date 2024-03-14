package tech.ada.rental.repository.impl;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.repository.VeiculoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoRepositoryImpl extends InMemoryRepository<Veiculo> implements VeiculoRepository {
    @Override
    public List<Veiculo> findByPartialName(String marca) {
        return objetos
                .stream().filter(o -> o.getModelo().contains(marca)).collect(Collectors.toList());
    }

    @Override
    public Veiculo findByPlaca(String placa) {
        return objetos.
                stream()
                .filter(o -> o.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }
}
