package tech.ada.rental.controller;

import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

public interface Controller<T> {
    Object criar(T t) throws VeiculoIndisponivelException, ElementoNaoEncotradoException, ElementosDuplicadosException;

    Object buscarPorId(long id) throws ElementoNaoEncotradoException;

    Object atualizar(T t);
    void deletar(long id) throws ElementoNaoEncotradoException;
    Iterable<T> listar();
}
