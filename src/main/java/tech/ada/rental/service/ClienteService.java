package tech.ada.rental.service;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;
import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;

import java.util.List;

public class ClienteService implements Service<Cliente> {

    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente criar(Cliente cliente) throws ElementosDuplicadosException {
        if (repository.findByDocumento(cliente.getDocumento()) == null) {
            return repository.save(cliente);
        }

        throw new ElementosDuplicadosException("Ja existe um cliente com esse documento");
    }

    @Override
    public Cliente atualizar(Cliente cliente) throws ElementoNaoEncotradoException {
        if (repository.findByDocumento(cliente.getDocumento()) != null) {
            return repository.save(cliente);
        }

        throw new ElementoNaoEncotradoException("Cliente nao encontrado");
    }

    @Override
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
    public List<Cliente> buscarTodos() {
        return repository.findAll();
    }

    public Cliente buscarPorDocumento(String documento) throws ElementoNaoEncotradoException {
        if (repository.findByDocumento(documento) != null) {
            return repository.findByDocumento(documento);
        }

        throw new ElementoNaoEncotradoException("Cliente nao foi encontrado");
    }

    public List<Cliente> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }
}
