package tech.ada.rental.dto;

import tech.ada.rental.enums.TipoVeiculo;

public record VeiculoDTO(TipoVeiculo tipoVeiculo, String placa, String modelo, String marca) {
}
