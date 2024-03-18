package tech.ada.rental.controller.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class UserEntryValidator {

    public static boolean validateDocumento(String documento) {
        if (documento == null || documento.isEmpty()) {
            return false;
        }

        Pattern patternRG = Pattern.compile("^\\d{1,2}\\.?\\d{3}\\.?\\d{3}-?[a-zA-Z0-9]{1}$");
        Pattern patternCPF = Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$");

        return patternRG.matcher(documento).matches() || patternCPF.matcher(documento).matches();
    }

    public static boolean validarCNH(String cnh) {
        if (cnh == null || cnh.length() != 11) {
            return false;
        }
        if (Character.isWhitespace(cnh.charAt(0))) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[A-Za-z]{2}\\d{9}$");
        return pattern.matcher(cnh).matches();
    }

    public static boolean validateNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            return false;
        }
        if (nome.length() < 3) {
            return false;
        }
        if (Character.isWhitespace(nome.charAt(0))) {
            return false;
        }

        Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ÿ\\s]+$");
        return pattern.matcher(nome).matches();
    }

    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validatePlaca(String placa) {
        Pattern pattern = Pattern.compile("^[A-Z]{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }

}
