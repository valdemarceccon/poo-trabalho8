package main;

import banco.Banco;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.HOURS;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Utaí");
        banco.criarConta(1234, "1234", 500.0);
        banco.criarConta(2345, "1234", 1500.0);
        banco.criarConta(3456, "1234", 15000.0);
        banco.criarConta(4567, "1234", 50.0);
        banco.criarConta(5678, "1234", 5.0);

        try {
            banco.sacar(1234, "1234", 250.0);
            banco.avancarRelogio(Duration.of(12, HOURS));
            banco.sacar(1234, "1234", 100.0);
        } catch (Exception excecaoContaInvalida) {
            excecaoContaInvalida.printStackTrace();
        }

        banco.avancarRelogio(Duration.of(12, HOURS));
        try {
            banco.sacar(2345, "2345", 250.0);
        } catch (Exception excecaoContaInvalida) {
            excecaoContaInvalida.printStackTrace();
        }

        try {
            banco.sacar(4567, "1234", 2500.0);
        } catch (Exception excecaoContaInvalida) {
            excecaoContaInvalida.printStackTrace();
        }

        try {
            banco.sacar(9876, "1234", 2500.0);
        } catch (Exception excecaoContaInvalida) {
            excecaoContaInvalida.printStackTrace();
        }

        try {
            banco.sacar(1234, "1234", 1.0);
            banco.sacar(2345, "1234", 1.0);
            banco.sacar(3456, "1234", 5000.0);
            banco.sacar(4567, "1234", 30.0);
            banco.sacar(5678, "1234", 5.0);
        } catch (Exception excecaoContaInvalida) {
            excecaoContaInvalida.printStackTrace();
        }
    }
}
