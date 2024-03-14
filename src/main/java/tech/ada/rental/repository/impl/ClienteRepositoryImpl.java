package tech.ada.rental.repository.impl;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;

public class ClienteRepositoryImpl extends InMemoryRepository<Cliente> implements ClienteRepository {

    @Override
    public Cliente findByDocumento(String documento) {
        return objetos.
                stream()
                .filter(o -> o.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }
}
