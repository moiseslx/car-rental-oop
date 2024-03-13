package tech.ada.rental.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Aluguel {

    private Long id;
    private Cliente cliente;
    private Veiculo veiculo;
    private BigDecimal precoAluguel;
    private LocalDateTime inicioAluguel;
    private LocalDateTime devolucao;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime inicioAluguel) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.inicioAluguel = inicioAluguel;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public BigDecimal getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(BigDecimal precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public LocalDateTime getInicioAluguel() {
        return inicioAluguel;
    }

    public void setInicioAluguel(LocalDateTime inicioAluguel) {
        this.inicioAluguel = inicioAluguel;
    }

    public LocalDateTime getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDateTime devolucao) {
        this.devolucao = devolucao;
    }
}
