package tech.ada.rental.controller;

import tech.ada.rental.service.api.Service;
import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

public abstract class CrudController<T> implements Controller<T> {
    Service service;
    public CrudController(Service service) {
        this.service = service;
    }
    @Override
    public Object criar(T t) throws VeiculoIndisponivelException, ElementoNaoEncotradoException, ElementosDuplicadosException {
        return this.service.criar(t);
    }
    @Override
    public Object buscarPorId(long id) throws ElementoNaoEncotradoException {
        return this.service.buscarPorId(id);
    }

    @Override
    public Object atualizar(T t) {
        return this.service.atualizar(t);
    }

    @Override
    public void deletar(long id) throws ElementoNaoEncotradoException {
        this.service.deletar(id);
    }

    @Override
    public Iterable<T> listar() {
        return this.service.buscarTodos();
    }
}
