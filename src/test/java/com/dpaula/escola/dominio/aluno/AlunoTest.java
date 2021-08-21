package com.dpaula.escola.dominio.aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlunoTest {

	private Aluno aluno;

	@BeforeEach
	void beforeEach() {
		aluno = new Aluno(
			new CPF("123.456.789-00"),
			"Fulano da Silva",
			new Email("fulano@email.com"));
	}

	@Test
	void deveriaPermitirAdicionar1Telefone() {
		aluno.adicionarTelefone("11", "99999999");
		assertEquals(1, aluno.getTelefones().size());
	}

	@Test
	void deveriaPermitirAdicionar2Telefones() {
		aluno.adicionarTelefone("11", "99999999");
		aluno.adicionarTelefone("11", "88888888");
		assertEquals(2, aluno.getTelefones().size());
	}

	@Test
	void naoDeveriaPermitirAdicionar3Telefones() {
		assertThrows(IllegalArgumentException.class, () -> {
			aluno.adicionarTelefone("11", "99999999");
			aluno.adicionarTelefone("11", "88888888");
			aluno.adicionarTelefone("11", "77777777");
		});
	}

}
