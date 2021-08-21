package com.dpaula.escola.dominio.aluno;

public class CPF {

	private final String numero;

	public CPF(final String numero) {
		if (numero == null ||
			!numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	@Override public String toString() {
		return numero;
	}
}
