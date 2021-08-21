package com.dpaula.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private final CPF cpf;
	private final String nome;
	
	private final Email email;
	
	private final List<Telefone> telefones = new ArrayList<>();
	
	public Aluno(final CPF cpf, final String nome, final Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicionarTelefone(final String ddd, final String numero) {
		if (telefones.size() == 2) {
			throw new IllegalArgumentException("Numero maximo de telefones atingido!");
		}
		telefones.add(new Telefone(ddd, numero));
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
}






