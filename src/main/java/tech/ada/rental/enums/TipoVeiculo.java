package tech.ada.rental.enums;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.service.CalculoAluguel;

import java.math.BigDecimal;

public enum TipoVeiculo implements CalculoAluguel {

    PEQUENO {

        @Override
        public BigDecimal calculoAluguel(Veiculo veiculo) {
            return null;
        }
    },
    MEDIO {
        @Override
        public BigDecimal calculoAluguel(Veiculo veiculo) {
            return null;
        }
    },
    SUV {
        @Override
        public BigDecimal calculoAluguel(Veiculo veiculo) {
            return null;
        }
    };

}
