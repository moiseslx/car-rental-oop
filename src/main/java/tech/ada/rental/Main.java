package tech.ada.rental;

import tech.ada.rental.enums.TipoCliente;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.impl.ClienteRepositoryImpl;
import tech.ada.rental.service.ClienteService;

public class Main {
    public static void main(String[] args) {
        ClienteService service = new ClienteService(new ClienteRepositoryImpl());
        System.out.println(service.criar(new Cliente(
                "Moises Almeida",
                "moises@me.com",
                "11 99999-9999",
                "11111111111",
                "11111111111",
                TipoCliente.PESSOA_FISICA)));

        System.out.println(service.criar(new Cliente(
                "Moises Almeida",
                "moises@me.com",
                "11 99999-9999",
                "11111111111",
                "11111111111",
                TipoCliente.PESSOA_FISICA)));
    }
}