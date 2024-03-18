package tech.ada.rental.service.api;

import tech.ada.rental.model.Aluguel;
import java.math.BigDecimal;

public interface CalculoDesconto {
    public BigDecimal calculoDesconto(Aluguel aluguel);
}
