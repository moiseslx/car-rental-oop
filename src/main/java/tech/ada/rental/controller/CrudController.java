package tech.ada.rental.controller;

import tech.ada.rental.service.api.Service;

public abstract class CrudController<T> {
    Service service;
    public CrudController(Service service) {
        this.service = service;
    }
    void criar(T t) {
      service.criar(t);
    }

    void buscar() {

    }

    void atualizar() {

    }

    void remover() {

    }

    void listar() {

    }
}
