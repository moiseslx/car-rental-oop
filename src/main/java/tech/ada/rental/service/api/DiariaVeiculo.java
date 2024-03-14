package tech.ada.rental.service.api;

import tech.ada.rental.model.Veiculo;
import java.math.BigDecimal;

public interface DiariaVeiculo {
    public BigDecimal definirValorDiaria(Veiculo veiculo);
}
