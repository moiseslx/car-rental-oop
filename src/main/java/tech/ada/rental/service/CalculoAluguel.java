package tech.ada.rental.service;

import tech.ada.rental.model.Veiculo;
import java.math.BigDecimal;

public interface CalculoAluguel {

    public BigDecimal calculoAluguel(Veiculo veiculo);
}
