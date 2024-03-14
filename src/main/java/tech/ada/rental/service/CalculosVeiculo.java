package tech.ada.rental.service;

import tech.ada.rental.model.Veiculo;
import java.math.BigDecimal;

public interface CalculosVeiculo {

    public BigDecimal calculoAluguel(Veiculo veiculo);
    public BigDecimal definirDiaria(Veiculo veiculo);
}
