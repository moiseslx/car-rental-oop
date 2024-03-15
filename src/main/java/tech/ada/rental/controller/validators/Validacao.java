package tech.ada.rental.controller.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class Validacao {
    public static boolean validarData(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Método para validar hora no formato "HH:mm:ss"
    public static boolean validarHora(String hora) {
        Pattern pattern = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$");
        Matcher matcher = pattern.matcher(hora);
        return matcher.matches();
    }

    // Método para validar CPF
    public static boolean validarCPF(String cpf) {
        // Implemente sua lógica de validação de CPF aqui
        return false; // A implementação real seria muito mais complexa
    }

    // Método para validar CNPJ
    public static boolean validarCNPJ(String cnpj) {
        // Implemente sua lógica de validação de CNPJ aqui
        return false; // A implementação real seria muito mais complexa
    }

    // Método para validar placa de carro brasileira
    public static boolean validarPlaca(String placa) {
        Pattern pattern = Pattern.compile("^[A-Z]{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Exemplos de uso
        System.out.println("Data válida? " + validarData("31/12/2022")); // Deve retornar true
        System.out.println("Hora válida? " + validarHora("13:45:30")); // Deve retornar true
        System.out.println("CPF válido? " + validarCPF("12345678901")); // Deve retornar false (implementação simulada)
        System.out.println("CNPJ válido? " + validarCNPJ("12345678000199")); // Deve retornar false (implementação simulada)
        System.out.println("Placa válida? " + validarPlaca("ABC-1234")); // Deve retornar true
    }
}
