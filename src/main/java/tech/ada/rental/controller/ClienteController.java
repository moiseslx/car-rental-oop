package tech.ada.rental.controller;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.ClienteService;
import tech.ada.rental.service.api.Service;

public class ClienteController extends CrudController<Cliente> {

    public ClienteController(ClienteService service) {
        super(service);
    }

}
