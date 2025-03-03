package empresa;

import java.time.LocalDate;

public class Pessoa {
	protected String nome;
	protected LocalDate dataNascimento;
	
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
}
