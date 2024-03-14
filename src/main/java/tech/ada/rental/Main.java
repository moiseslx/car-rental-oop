package tech.ada.rental;

import tech.ada.rental.enums.TipoCliente;
import tech.ada.rental.model.Cliente;
import tech.ada.rental.repository.ClienteRepository;
import tech.ada.rental.repository.impl.ClienteRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Moises", "moises@moises.com", "00000000000", "0000000000", "000000000", TipoCliente.PESSOA_FISICA);
        ClienteRepository repository = new ClienteRepositoryImpl();

        System.out.println(cliente);
        System.out.println(repository.save(cliente));
        System.out.println(repository.findById(0L));
        repository.deleteById(0L);
        System.out.println(repository.findAll());
    }
}