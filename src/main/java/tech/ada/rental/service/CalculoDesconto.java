package tech.ada.rental.service;

import tech.ada.rental.model.Cliente;
import java.math.BigDecimal;

public interface CalculoDesconto {
    public BigDecimal calculoDesconto(Cliente cliente);
}
