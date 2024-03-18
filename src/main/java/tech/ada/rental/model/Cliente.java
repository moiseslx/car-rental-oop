package tech.ada.rental.model;

import tech.ada.rental.enums.TipoCliente;

public class Cliente  extends  IdBasedModel {

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
    public String toString() {
        return "Cliente{" + "id=" + getId() +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", documento='" + documento + '\'' +
                ", cnh='" + cnh + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
