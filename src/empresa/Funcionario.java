package empresa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void aumentarSalario(BigDecimal percentual) {
        this.salario = this.salario.add(this.salario.multiply(percentual));
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Nome: %s, Data de Nascimento: %s, Salário: %,.2f, Função: %s",
                nome, dataNascimento.format(formatter), salario, funcao);
    }
}

