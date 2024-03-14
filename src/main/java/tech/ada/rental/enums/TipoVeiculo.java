package tech.ada.rental.enums;

import tech.ada.rental.model.Veiculo;
import tech.ada.rental.service.api.DiariaVeiculo;
import java.math.BigDecimal;

public enum TipoVeiculo implements DiariaVeiculo {

    PEQUENO {
        @Override
        public BigDecimal definirValorDiaria(Veiculo veiculo) {
            return new BigDecimal("100.00");
        }
    },
    MEDIO {
        @Override
        public BigDecimal definirValorDiaria(Veiculo veiculo) {
            return new BigDecimal("150.00");
        }
    },
    SUV {
        @Override
        public BigDecimal definirValorDiaria(Veiculo veiculo) {
            return new BigDecimal("200.00");
        }
    };

}
