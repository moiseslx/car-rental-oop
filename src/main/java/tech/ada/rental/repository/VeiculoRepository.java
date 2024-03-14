package tech.ada.rental.repository;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends Repository<Veiculo> {

    List<Veiculo> findByPartialName (String marca);

    Veiculo findByPlaca(String placa);

}
