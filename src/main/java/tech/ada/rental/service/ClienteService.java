package tech.ada.rental.service;

import org.jetbrains.annotations.NotNull;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;
import tech.ada.rental.service.api.Service;

public class ClienteService implements Service<Cliente> {

    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        if (repository.findByDocumento(cliente.getDocumento()) != null) {
            // TODO: Implementar tratamento de erros
            throw new RuntimeException("Ja existe um cliente com o documento informado");
        }

        return repository.save(cliente);
    }
    @Override
    public Cliente atualizar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id);
    }
}
