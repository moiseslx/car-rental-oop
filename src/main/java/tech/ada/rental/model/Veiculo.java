package tech.ada.rental.model;

import tech.ada.rental.enums.TipoVeiculo;

import java.math.BigDecimal;

public class Veiculo {

    private Long id;
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

    public Long getId() {
        return id;
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

    private void setId(Long id) {
        this.id = id;
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

    private void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
