package tech.ada.rental.service;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;

public class ClienteService {

    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(Cliente cliente) {
        if (repository.findByDocumento(cliente.getDocumento()) != null) {
            throw new RuntimeException("Ja existe um cliente com o documento informado");
        }

        return repository.save(cliente);
    }
}
