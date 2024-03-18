package tech.ada.rental.enums;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.service.api.CalculoDesconto;
import java.math.BigDecimal;

public enum TipoCliente implements CalculoDesconto {

    PESSOA_FISICA {

        @Override
        public BigDecimal calculoDesconto(Aluguel aluguel) {
            if (aluguel.getDiarias() > 5) {
                return new BigDecimal("0.95");
            }
            return new BigDecimal("1.00");
        }
    },
    PESSOA_JURIDICA {

        @Override
        public BigDecimal calculoDesconto(Aluguel aluguel) {
            if (aluguel.getDiarias() > 3) {
                return new BigDecimal("0.90");
            }
            return new BigDecimal("1.00");
        }
    }
}
