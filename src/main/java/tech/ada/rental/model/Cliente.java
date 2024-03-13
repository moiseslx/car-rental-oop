package tech.ada.rental.model;

import tech.ada.rental.enums.TipoCliente;

import java.util.Objects;

public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String documento;
    private String cnh;
    private TipoCliente tipo;

    public Cliente(String nome, String email, String telefone, String documento, String cnh, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        this.cnh = cnh;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(telefone, cliente.telefone) && Objects.equals(documento, cliente.documento) && Objects.equals(cnh, cliente.cnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefone, documento, cnh);
    }
}
