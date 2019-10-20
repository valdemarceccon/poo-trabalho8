package banco;

import excecoes.ExcecaoSaldoInsuficiente;
import excecoes.ExcecaoSenhaInvalida;

import java.util.Objects;

public class ContaCorrente {
    private final Integer numero;
    private String senha;
    private Double saldo;

    ContaCorrente(Integer numero, String senha, Double saldo) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void retirar(Double valor, String senha) throws ExcecaoSaldoInsuficiente, ExcecaoSenhaInvalida {
        if (senha == null || !senha.equals(this.senha))
            throw new ExcecaoSenhaInvalida();

        if (valor > saldo)
            throw new ExcecaoSaldoInsuficiente();

        this.saldo -= valor;
        System.out.printf("Valor de R$ %.2f sacado com sucesso%n", valor);
        System.out.printf("Saldo de R$ %.2f na conta %d%n%n", saldo, numero);
    }
}
