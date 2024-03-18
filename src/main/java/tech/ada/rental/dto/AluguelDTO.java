package tech.ada.rental.dto;

import tech.ada.rental.model.Aluguel;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.model.Veiculo;

import java.time.LocalDateTime;

public record AluguelDTO(Cliente cliente, Veiculo veiculo, LocalDateTime inicioAluguel) {

    public Aluguel toAluguel() {
        return new Aluguel(cliente, veiculo, inicioAluguel);
    }
}
