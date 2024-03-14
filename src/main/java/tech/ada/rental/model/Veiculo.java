package tech.ada.rental.model;

import tech.ada.rental.enums.TipoVeiculo;

import java.math.BigDecimal;

public class Veiculo extends IdBasedModel{

    private TipoVeiculo tipoVeiculo;
    private String placa;
    private String modelo;
    private String marca;
    private boolean disponibilidade;
    private BigDecimal valorDiaria;

    public Veiculo(TipoVeiculo tipoVeiculo, String placa, String modelo, String marca) {
        this.tipoVeiculo = tipoVeiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.disponibilidade = true;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

        public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "tipoVeiculo=" + tipoVeiculo +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}
