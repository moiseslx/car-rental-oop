package tech.ada.rental.service;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;
import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;

public class ClienteService implements Service<Cliente> {

    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(Cliente cliente) throws ElementosDuplicadosException {
        if (repository.findByDocumento(cliente.getDocumento()) == null) {
            return repository.save(cliente);
        }

        throw new ElementosDuplicadosException("Ja existe um cliente com esse documento");
    }
    public Cliente atualizar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deletar(Long id) throws ElementoNaoEncotradoException {
        if (repository.findById(id) != null) {
            repository.deleteById(id);
        }

        throw new ElementoNaoEncotradoException("Cliente nao foi encontrado");
    }

    public Cliente buscarPorId(Long id) throws ElementoNaoEncotradoException{
        if (repository.findById(id) != null) {
            return repository.findById(id);
        }

        throw new ElementoNaoEncotradoException("Cliente nao foi encontrado");
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }
}
