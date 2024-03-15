package tech.ada.rental.controller;

import tech.ada.rental.service.AluguelService;

public class AluguelController {

    AluguelService aluguelService;

    public AluguelController (AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }
}
