package tech.ada.rental.service;

import org.jetbrains.annotations.NotNull;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;

public class ClienteService {

    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(@NotNull Cliente cliente) {
        if (repository.findByDocumento(cliente.getDocumento()) != null) {
            // TODO: Implementar tratamento de erros
            throw new RuntimeException("Ja existe um cliente com o documento informado");
        }

        return repository.save(cliente);
    }
    public Cliente atualizar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id);
    }
}
