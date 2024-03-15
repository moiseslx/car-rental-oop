package tech.ada.rental.model;

import tech.ada.rental.enums.AluguelStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aluguel extends IdBasedModel {

    private Cliente cliente;
    private Veiculo veiculo;
    private BigDecimal precoAluguel;
    private LocalDateTime inicioAluguel;
    private LocalDateTime devolucao;
    private Long diarias;
    private AluguelStatus status;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime inicioAluguel) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.inicioAluguel = inicioAluguel;
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

    public Long getDiarias() {
        return diarias;
    }

    public void setDiarias(Long diarias) {
        this.diarias = diarias;
    }

    public AluguelStatus getStatus() {
        return status;
    }

    public void setStatus(AluguelStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "cliente=" + cliente.getNome() +
                ", veiculo=" + veiculo.getModelo() + "|" + veiculo.isDisponibilidade() +
                ", precoAluguel=" + precoAluguel +
                ", inicioAluguel=" + inicioAluguel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                ", devolucao=" + devolucao +
                ", status=" + status +
                '}';
    }
}
