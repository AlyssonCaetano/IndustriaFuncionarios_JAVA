package empresa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        
        // Aumentar salário
        funcionarios.forEach(f -> f.aumentarSalario(new BigDecimal("0.10")));
        
        // Agrupar por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Imprimir funcionários agrupados
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(System.out::println);
        });

        // Filtrar aniversariantes de outubro e dezembro
        List<Funcionario> aniversariantes = funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .collect(Collectors.toList());
        System.out.println("\nAniversariantes de outubro e dezembro:");
        aniversariantes.forEach(System.out::println);
        
        // Funcionário mais velho
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        System.out.println("\nFuncionário mais velho: " + maisVelho.getNome() + ", Idade: " + 
                           (LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear()));

        // Ordem alfabética
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.forEach(System.out::println);

        // Total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + totalSalarios);

        // Salários mínimos por funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários mínimos ganhos por funcionário:");
        funcionarios.forEach(f -> {
            System.out.println(f.getNome() + ": " + f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP));
        });
    }
}

