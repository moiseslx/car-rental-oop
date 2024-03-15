package tech.ada.rental.controller;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.service.VeiculoService;
import tech.ada.rental.service.api.Service;

public class VeiculoController {

    VeiculoService veiculoService;
    public VeiculoController (VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
}


