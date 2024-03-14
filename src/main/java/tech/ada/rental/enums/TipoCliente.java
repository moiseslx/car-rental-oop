package tech.ada.rental.enums;

import tech.ada.rental.model.Cliente;
import tech.ada.rental.service.CalculoDesconto;
import java.math.BigDecimal;

public enum TipoCliente implements CalculoDesconto {

    PESSOA_FISICA {

        @Override
        public BigDecimal calculoDesconto(Cliente cliente) {
            return null;
        }
    },
    PESSOA_JURIDICA {

        @Override
        public BigDecimal calculoDesconto(Cliente cliente) {
            return null;
        }
    }
}
