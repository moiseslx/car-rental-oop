package tech.ada.rental.service.api;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.model.Cliente;

public interface Service<T> {
    T criar(T t);

    T buscarPorId(long l);

    T atualizar(T t);

    void deletar(Long id);

    T buscarPorId(Long id);
}
