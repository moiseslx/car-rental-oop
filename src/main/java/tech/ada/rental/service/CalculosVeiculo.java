package tech.ada.rental.service;

import tech.ada.rental.model.Veiculo;
import java.math.BigDecimal;

public interface CalculosVeiculo {

    public BigDecimal calcularAluguel(Veiculo veiculo);
    public BigDecimal definirValorDiaria(Veiculo veiculo);
}
