package tech.ada.rental.enums;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.service.CalculosVeiculo;
import java.math.BigDecimal;

public enum TipoVeiculo implements CalculosVeiculo {

    PEQUENO {
        @Override
        public BigDecimal calculoAluguel(Veiculo veiculo) {
            return null;
        }

        @Override
        public BigDecimal definirDiaria(Veiculo veiculo) {
            return new BigDecimal("100.00");
        }
    },
    MEDIO {
        @Override
        public BigDecimal calculoAluguel(Veiculo veiculo) {
            return null;
        }

        @Override
        public BigDecimal definirDiaria(Veiculo veiculo) {
            return new BigDecimal("150.00");
        }
    },
    SUV {
        @Override
        public BigDecimal calculoAluguel(Veiculo veiculo) {
            return null;
        }

        @Override
        public BigDecimal definirDiaria(Veiculo veiculo) {
            return new BigDecimal("200.00");
        }
    };

}
