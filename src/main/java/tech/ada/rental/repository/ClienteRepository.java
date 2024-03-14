package tech.ada.rental.repository;

import tech.ada.rental.model.Cliente;

public interface ClienteRepository extends Repository<Cliente> {

    Cliente findByDocumento(String documento);
}
