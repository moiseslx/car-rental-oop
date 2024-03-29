package tech.ada.rental.service.api;

import tech.ada.rental.service.exception.ElementoNaoEncotradoException;
import tech.ada.rental.service.exception.ElementosDuplicadosException;
import tech.ada.rental.service.exception.VeiculoIndisponivelException;

import java.util.List;

public interface Service<T> {
    T criar(T t) throws ElementoNaoEncotradoException, ElementosDuplicadosException, VeiculoIndisponivelException;

    T atualizar(T t) throws ElementoNaoEncotradoException;

    void deletar(Long id) throws ElementoNaoEncotradoException;

    T buscarPorId(Long id) throws ElementoNaoEncotradoException;

    List<T> buscarTodos() throws ElementoNaoEncotradoException;
}
