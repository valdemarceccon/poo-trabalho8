package banco;

import excecoes.ExcecaoContaInvalida;
import excecoes.ExcecaoHorarioInvalido;
import excecoes.ExcecaoSaldoInsuficiente;
import excecoes.ExcecaoSenhaInvalida;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Banco {
    private final String nome;
    private LocalTime relogio = LocalTime.of(15, 0);

    private final Map<Integer, ContaCorrente> contas = new HashMap<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void criarConta(Integer numero, String senha, Double saldo) {
        contas.put(numero, new ContaCorrente(numero, senha, saldo));
    }

    public void sacar(int numero, String senha, Double valor) throws ExcecaoContaInvalida, ExcecaoSaldoInsuficiente, ExcecaoSenhaInvalida, ExcecaoHorarioInvalido {
        ContaCorrente contaCorrente = contas.get(numero);
        if (contaCorrente == null)
            throw new ExcecaoContaInvalida();

        if (relogio.isBefore(LocalTime.of(8, 0)) || relogio.isAfter(LocalTime.of(22, 0)))
            throw new ExcecaoHorarioInvalido();

        contaCorrente.retirar(valor, senha);

    }

    public void avancarRelogio(Duration tempo) {
        this.relogio = relogio.plus(tempo);
    }

}
