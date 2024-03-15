package tech.ada.rental.controller;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.api.Service;

public class ClienteControllerImpl extends CrudController<Cliente> implements Controller<Cliente> {

    public ClienteControllerImpl(Service service) {
        super(service);
    }

}
