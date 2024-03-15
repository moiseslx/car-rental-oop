package tech.ada.rental.repository;

import tech.ada.rental.model.Cliente;

import java.util.List;

public interface ClienteRepository extends Repository<Cliente> {

    Cliente findByDocumento(String documento);

    List<Cliente> findByNome(String nome);
}
