package tech.ada.rental.dto;

import tech.ada.rental.enums.TipoVeiculo;
import tech.ada.rental.model.Veiculo;

public record VeiculoDTO(TipoVeiculo tipoVeiculo, String placa, String modelo, String marca) {

    public Veiculo toVeiculo() {
        return new Veiculo(tipoVeiculo, placa, modelo, marca);
    }
}
